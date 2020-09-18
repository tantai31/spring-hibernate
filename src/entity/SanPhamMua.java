package entity;

public class SanPhamMua extends Sua {
	private int soLuongMua;

	public SanPhamMua() {
		super();
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public double thanhTien() {
		return soLuongMua * getDonGia();
	}

}
