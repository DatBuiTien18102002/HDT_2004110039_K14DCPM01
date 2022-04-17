import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleInputing {
    private Scanner sc = new Scanner(System.in);

    public Scanner getNhap() {
        return sc;
    }

    public HangHoa nhapHangHoa() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("\nMa hang: ");
        String maHang = sc.nextLine();
        System.out.print("Ten hang: ");
        String tenHang = sc.nextLine();
        System.out.print("So luong ton: ");
        int soLuongTon = sc.nextInt();
        System.out.print("Don gia: ");
        double donGia = sc.nextDouble();
        System.out.println("1.Hang Dien May");
        System.out.println("2.Hang Thuc Pham");
        System.out.println("3.Hang Sanh Su");
        System.out.print("Lua Chon: ");
        int luaChon = sc.nextInt();
        HangHoa hH;
        if (luaChon == 1) {
            System.out.print("Thoi gian bao hanh: ");
            int tGBaoHanh = sc.nextInt();
            System.out.print("Cong suat: ");
            double congSuat = sc.nextDouble();
            sc.nextLine();
            System.out.println("");
            hH = new HangDienMay(maHang, tenHang, soLuongTon, donGia, tGBaoHanh, congSuat);
        } else if (luaChon == 2) {
            Date ngaySanXuat = null;
            Date ngayHetHan = null;
            sc.nextLine();
            System.out.print("Ngay san xuat(dd/mm/yyyy): ");
            try {
                ngaySanXuat = sdf.parse(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Nhap sai cau truc!!!");
            }
            System.out.print("Ngay het han(dd/mm/yyyy): ");
            try {
                ngayHetHan = sdf.parse(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Nhap sai cau truc!!!");
            }
            System.out.print("Nha cung cap: ");
            String nhaCungCap = sc.nextLine();
            System.out.println("");
            hH = new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        } else {
            Date ngayNhapkho = null;
            sc.nextLine();
            System.out.print("Nha san xuat: ");
            String nhaSanXuat = sc.nextLine();
            System.out.print("Ngay nhap kho(dd/mm/yyyy): ");
            try {
                ngayNhapkho = sdf.parse(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Nhap sai cau truc!!!");
            }
            System.out.println("");
            hH = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapkho);
        }
        return hH;
    }
}
