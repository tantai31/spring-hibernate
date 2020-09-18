package controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import businessLogic.KhachHangBL;
import businessLogic.LoaiSuaBL;
import entity.KhachHang;
import entity.LoaiSua;

@RestController
public class RestControllers {

	@GetMapping({"/khach-hang"})
	public List<KhachHang> kh(){
		return KhachHangBL.docTatCaKH();
	}
	@GetMapping("khach-hang/{p}")
	public KhachHang docTheoID(@PathVariable(name="id") String maKH) {
		return KhachHangBL.docTheoMa(maKH);
	}
	@PostMapping("/them-khach-hang")
	public KhachHang themKH(@RequestBody KhachHang kh) {
		return KhachHangBL.themKH(kh);
	}
	@PutMapping("/sua-khach-hang")
	public KhachHang sua(@RequestBody KhachHang kh) {
		return KhachHangBL.suaKH(kh);
	}
	@DeleteMapping("/xoa-khach-hang/{p}")
	public KhachHang xoaKH(@PathVariable(name="p") String maKH) {
		return KhachHangBL.xoaKH(maKH);
	}
	
}
