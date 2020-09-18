package businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.Sua;
public class SuaBL {
	private static Session session = CSDL.getSession().openSession();
	
	public static List<Sua> suaTheoTrang(Integer trang,Integer soDongMoiTrang){
		List<Sua> ds = null;
		int vt = (trang - 1)*soDongMoiTrang;
		try{
			String sql = " from Sua ";
			ds = session.createQuery(sql,Sua.class).setFirstResult(vt).setMaxResults(soDongMoiTrang).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public static int tongSoDong(){
		List<Sua> tong = null;
		try{
			String sql = "select s from Sua s";
			tong = session.createQuery(sql).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tong.size();
	}
	public static List<Sua> suaBanChay(int top){
		List<Sua> dsSua = null;
		try{
			String sql = "select s,sum(ct.soLuong) as tsl from Sua s "
					+ "left join fetch s.hangSua "
					+ "left join fetch s.loaiSua "
					+ "join s.ctHoadons ct "
					+ "group by s order by tsl desc";
			List<Object[]> dsObj = session.createQuery(sql)
					.setFirstResult(0)
					.setMaxResults(top)
					.list();
			dsSua = new ArrayList<Sua>();
			for(Object[] m:dsObj) {
				Sua s = (Sua)m[0];
				dsSua.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}
	public static Sua docTheoMa(String maSua) {
		Sua s = null;
		try {
			String sql = "from Sua as s where s.maSua = :maSua";
			s = session.get(Sua.class, maSua);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
	public static List<Sua> docTheoTenLoaiHang(String tenSua,String maLoai,String maHang) {
		List<Sua> s = null;
		try {
			String sql = "select s from Sua s left join fetch s.loaiSua left join fetch s.hangSua where s.hangSua.maHangSua = :maHang and s.loaiSua.maLoaiSua = :maLoai and s.tenSua like : tenSua ";
			s = session.createQuery(sql,Sua.class).setParameter("maLoai", maLoai).setParameter("maHang", maHang).setParameter("tenSua","%"+tenSua+"%").list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
}
