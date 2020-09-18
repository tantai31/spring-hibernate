package businessLogic;

import java.util.List;

import javax.transaction.SystemException;


import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.HangSua;
import entity.LoaiSua;

public class LoaiSuaBL {
	private static Session session = CSDL.getSession().openSession();
	
	public static List<LoaiSua> docTatCa(){
		List<LoaiSua> ds = null;
		try {
			String sql = "select ls from LoaiSua ls";
			ds = session.createQuery(sql, LoaiSua.class).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public static int tongSuaTheoLoai(String maLoai) {
		List<LoaiSua> ds = null;
		try {
			String sql = "select s from Sua s where s.loaiSua.maLoaiSua = :maLoai";
			ds = session.createQuery(sql).setParameter("maLoai", maLoai).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds.size();
	}
	public static List<LoaiSua> soTrangTheoHang(String maLoai,Integer trang,Integer soDongMoiTrang){
		int vt = (trang-1)*soDongMoiTrang;
		List<LoaiSua> ds = null;
		try {
			String sql = "select s from Sua s where s.loaiSua.maLoaiSua = :maLoai";
			ds = session.createQuery(sql).setParameter("maLoai",maLoai).setFirstResult(vt).setMaxResults(soDongMoiTrang).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public static void themLoaiSua(LoaiSua ls) {
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.persist(ls);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null) ts.rollback();
		} finally {
			session.close();
		}
	}

}
