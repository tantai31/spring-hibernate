package controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import businessLogic.GioHang;
import businessLogic.HangSuaBL;
import businessLogic.LoaiSuaBL;
import businessLogic.SuaBL;
import entity.HangSua;
import entity.LoaiSua;
import entity.Sua;

@Controller
public class HomeController {	
	private int soDongMoiTrang = 8;
	
	@RequestMapping({"/","/{p}"})
	public String home(Model model,@PathVariable(value="p",required = false) Integer trang,HttpServletRequest request) {
		List<Sua> sua = new ArrayList<Sua>();
		HttpSession session = request.getSession();
		int total = 0;
		if(trang==null) {
			sua = SuaBL.suaTheoTrang(1, soDongMoiTrang);
		}else {
			sua = SuaBL.suaTheoTrang(trang, soDongMoiTrang);
		}
		total = SuaBL.tongSoDong();
		session.setAttribute("hs", HangSuaBL.docTatCa());
		session.setAttribute("ls", LoaiSuaBL.docTatCa());
		model.addAttribute("sua", sua);
		model.addAttribute("total", (int)Math.ceil(total/(double)soDongMoiTrang));
		return "home";
	}
	@RequestMapping({"hang-sua"})
	public String hangSua(Model model,@RequestParam(name="maHang") String maHang,@RequestParam(name="p") Integer trang) {
		List<HangSua> hs = new ArrayList<HangSua>();
		int total = 0;

		hs = HangSuaBL.soTrangTheoHang(maHang, trang, soDongMoiTrang);
		
		total = HangSuaBL.soDongDocTheoHang(maHang);
		model.addAttribute("total", (int)Math.ceil(total/(double)soDongMoiTrang));
		model.addAttribute("hs", hs);
		return "sua-theo-hang";
	}
	@RequestMapping("loai-sua")
	public String loaiSua(Model model,@RequestParam(name="maLoai") String maLoai,@RequestParam(name="p") Integer trang) {
		List<LoaiSua> ls = new ArrayList<LoaiSua>();
		int total = 0;
		
		ls = LoaiSuaBL.soTrangTheoHang(maLoai, trang, soDongMoiTrang);
		
		total = LoaiSuaBL.tongSuaTheoLoai(maLoai);
		model.addAttribute("total", Math.ceil(total/(double)soDongMoiTrang));
		model.addAttribute("ls", ls);
		return "sua-theo-loai";
	}
	@RequestMapping("sua-ban-chay")
	public String banChay(Model model,HttpServletRequest request) {
		String maSua;
		if(request.getParameter("maSua")==null) {
			model.addAttribute("s", SuaBL.docTheoMa("AB0001"));
		}else {
			maSua = request.getParameter("maSua");
			model.addAttribute("s", SuaBL.docTheoMa(maSua));
		}
		model.addAttribute("sua", SuaBL.suaBanChay(4));
		return "sua-ban-chay";
	}
	@RequestMapping("chi-tiet-san-pham")
	public String chiTiet(Model model , HttpServletRequest request) {
		String maSua;
		maSua = request.getParameter("maSua");
		model.addAttribute("s", SuaBL.docTheoMa(maSua));
		return "chi-tiet-san-pham";
	}
	@RequestMapping("tim-kiem-sua")
	public String timSua(Model model,HttpServletRequest request) {
		String ten,hang,loai;
		List<Sua> ds = new ArrayList<Sua>();
		if(request.getParameter("btnTim")!=null) {
			ten = request.getParameter("txtTenSua");
			hang = request.getParameter("cboHangSua");
			loai = request.getParameter("cboLoaiSua");
			ds = SuaBL.docTheoTenLoaiHang(ten, loai, hang);
			model.addAttribute("s", ds);
		}
		return "tim-kiem-sua";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public String login(Model model,HttpServletRequest request) {
		String user,pass;
		user = request.getParameter("txtUser");
		pass = request.getParameter("txtPass");
		if(user.equals("tantai@gmail.com") && pass.equals("tai159357")) {
			HttpSession session = request.getSession();
			session.setAttribute("nguoidung", "Bui Tan Tai");
			return "redirect:them-san-pham";
		}
		return "login";
	}
	@RequestMapping("/them-san-pham")
	public String them(Model model) {
		model.addAttribute("ls", LoaiSuaBL.docTatCa());
		return "them-san-pham";
	}
	@RequestMapping(path="/them-san-pham",method=RequestMethod.POST)
	public String them(HttpServletRequest request,Model model) {
		String maLoai,tenLoai;
		maLoai = request.getParameter("txtMaLoai");
		tenLoai = request.getParameter("txtTen");
		LoaiSua ls = new LoaiSua();
		ls.setMaLoaiSua(maLoai);
		ls.setTenLoai(tenLoai);
		LoaiSuaBL.themLoaiSua(ls);
		return "them-san-pham";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session!=null) {
			session.invalidate();
		}
		return"redirect:/";
	}
	
	
	@RequestMapping(path="/them-vao-gio",method=RequestMethod.POST)
	@ResponseBody
	public String gioHang(HttpServletRequest request) {
		String idsp = request.getParameter("idsp");
		int slm = Integer.parseInt(request.getParameter("slm"));
		HttpSession session = request.getSession();
		GioHang gioHang = (GioHang) session.getAttribute("gioHang");
		if(gioHang==null) {
			gioHang = new GioHang();
			session.setAttribute("gioHang", gioHang);
		}
		gioHang.them(idsp, slm);
		double tongTien = gioHang.tongTien();
		int smh = gioHang.soMatHang();
		return String.valueOf(tongTien)+","+String.valueOf(smh);
	}
	@RequestMapping("trang-gio-hang")
	public String trangGioHang() {
		return "trang-gio-hang";
	}
	
}
