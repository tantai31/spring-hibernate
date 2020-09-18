package businessLogic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import entity.SanPhamMua;
import entity.Sua;

public class GioHang {
	private static Hashtable<String, Integer> dsgh;
	public GioHang() {
		dsgh = new Hashtable<String, Integer>();
	}
	public void them(String maSua,int donGia) {
		if(dsgh.containsKey(maSua)) {
			dsgh.replace(maSua, dsgh.get(maSua)+donGia);
		}else {
			dsgh.put(maSua, donGia);
		}
	}
	public int soMatHang() {
		return dsgh.size();
	}
	public double tongTien() {
		double tt = 0;
		for(String maSua:dsgh.keySet()) {
			Sua s = SuaBL.docTheoMa(maSua);
			tt += s.getDonGia() * dsgh.get(maSua); 
		}
		return tt;
	}
	public static List<SanPhamMua> danhSachGioHang(){
		List<SanPhamMua> ds = new ArrayList<SanPhamMua>();
		for(String maSua:dsgh.keySet()) {
			Sua s = SuaBL.docTheoMa(maSua);
			
			SanPhamMua spm = new SanPhamMua();
			spm.setDonGia(s.getDonGia());
			spm.setHangSua(s.getHangSua());
			spm.setHinh(s.getHinh());
			spm.setLoaiSua(s.getLoaiSua());
			spm.setLoiIch(s.getLoiIch());
			spm.setMaSua(s.getMaSua());
			spm.setTenSua(s.getTenSua());
			spm.setTpDinhDuong(s.getTpDinhDuong());
			spm.setTrongLuong(s.getTrongLuong());
			
			spm.setSoLuongMua(dsgh.get(maSua));
			
			ds.add(spm);
		}
		return ds;
	}

}
