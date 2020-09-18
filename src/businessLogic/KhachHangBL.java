package businessLogic;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.KhachHang;

public class KhachHangBL {
	private static Session session = CSDL.getSession().openSession();
	
	public static KhachHang docTheoMa(String maKH) {
		KhachHang kh = null;
		try {
			String sql = "select kh from KhachHang kh where kh.maKhachHang = :maKhachHang";
			kh = session.get(KhachHang.class, maKH);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}
	public static List<KhachHang> docTatCaKH() {
		List<KhachHang> kh = null;
		try {
			String sql = "select kh from KhachHang as kh";
			kh = session.createQuery(sql,KhachHang.class).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}
	public static  KhachHang themKH(KhachHang kh) {
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.persist(kh);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null) ts.rollback(); 
		}finally {
			session.close();
		}
		return kh;
	}
	public static KhachHang suaKH(KhachHang kh) {
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.update(kh);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null) ts.rollback();
		}finally {
			session.close();
		}
		return kh;
	}
	public static KhachHang xoaKH(String maKH) {
		Transaction ts = null;
		KhachHang kh = null;
		try {
			ts = session.beginTransaction();
		    kh = docTheoMa(maKH);
			session.delete(kh);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(ts!=null) ts.rollback();
		}finally {
			session.close();
		}
		return kh;
	}
}
