import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Date ngayNhapkho;

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date getNgayNhapkho() {
        return ngayNhapkho;
    }

    public void setNgayNhapkho(Date ngayNhapkho) {
        if (ngayNhapkho != null) {
            this.ngayNhapkho = ngayNhapkho;
        } else {
            System.err.println("Ngay nhap kho khong duoc de trong!!!");
            System.err.println("Chuyen sang mac dinh la ngay 01/01/1970");
            System.err.println("Ngay nhap kho(dd/mm/yyyy): 01/01/1970\n");
            try {
                this.ngayNhapkho = sdf.parse("01/01/1970");
            } catch (ParseException e) {
            }
        }
        this.ngayNhapkho = ngayNhapkho;
    }

    public HangSanhSu() {
    }

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
            Date ngayNhapkho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setNhaSanXuat(nhaSanXuat);
        this.setNgayNhapkho(ngayNhapkho);
    }

    @Override
    double tinhTienVAT() {

        return this.getDonGia() * 0.1;
    }

    @Override
    String danhGia() {
        if (this.getSoLuongTon() > 50 && tinhTGLuuKho() > 10) {
            return "Ban cham";
        }
        return "";
    }

    public long tinhTGLuuKho() {

        if (this.ngayNhapkho.after(new Date())) {
            return 0;
        }
        long startValue = this.ngayNhapkho.getTime();// chuyển ngày nhập kho thành mili giây
        long endValue = new Date().getTime(); // chuyển đổi ngày hiện tại thành mili giây
        long tmp = Math.abs(endValue - startValue); // lấy hiệu giá trị tuyệt đối của hai mili giây

        return tmp / (24 * 60 * 60 * 1000); // chia cho số mili giây trong một ngày
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String toString() {

        return "Hang sanh su" + super.toString() + "\nNha san xuat: " + this.nhaSanXuat 
                + "\nNgay nhap kho: "+ sdf.format(this.ngayNhapkho)
                + "\nThoi gian ton kho: " + this.tinhTGLuuKho() + " ngay" + "\nTien VAT: " + this.tinhTienVAT() + " dong"
                + "\nDanh gia: " + this.danhGia() + "\n";
    }

}
