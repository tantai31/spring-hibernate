package businessLogic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.HangSua;
import entity.Sua;

public class HangSuaBL {
	public static List<HangSua> docTatCa(){
		List<HangSua> ds = null;
		try(Session session = CSDL.getSession().openSession()) {
			String sql = "select h from HangSua h";
			ds = session.createQuery(sql,HangSua.class).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public static int soDongDocTheoHang(String maHang){
		List<HangSua> ds = null;
		try(Session session = CSDL.getSession().openSession()) {
			String sql = "select s from Sua s where s.hangSua.maHangSua = :maHang";
			ds = session.createQuery(sql).setParameter("maHang", maHang).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds.size();
	}
	public static List<HangSua> soTrangTheoHang(String maHang,Integer trang,Integer soDongMoiTrang){
		int vt = (trang-1)*soDongMoiTrang;
		List<HangSua> ds = null;
		try(Session session = CSDL.getSession().openSession()) {
			String sql = "select s from Sua s where s.hangSua.maHangSua = :maHang";
			ds = session.createQuery(sql).setParameter("maHang",maHang).setFirstResult(vt).setMaxResults(soDongMoiTrang).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
}
