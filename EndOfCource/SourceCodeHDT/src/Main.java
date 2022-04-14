import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DanhSachHangHoa dSHH = new DanhSachHangHoa();
        String nhapTiep = null;
        int luaChon;
        dSHH.layTuFile("danhsachhanghoa.dat");
        dSHH.inDS();
        do {
            System.out.println("*********************** MENU ***********************");
            System.out.println("**  1.Quan ly danh sach                           **");
            System.out.println("**  2.Tra cuu                                     **");
            System.out.println("**  3.Bao cao - Thong ke                          **");
            System.out.println("**  4.Tien ich                                    **");
            System.out.println("**  0.Thoat                                       **");
            System.out.println("****************************************************");
            System.out.print("Lua chon :");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case (1):
                    int luaChon1;
                    do {
                        System.out.println("***************** Quan ly danh sach ****************");
                        System.out.println("**  1.Them hang hoa vao danh sach                 **");
                        System.out.println("**  2.In danh sach hang hoa                       **");
                        System.out.println("**  3.Sua hang hoa theo ma hang                   **");
                        System.out.println("**  4.Xoa hang hoa theo ma hang                   **");
                        System.out.println("**  5.Xoa hang hoa theo ten hang                  **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon :");
                        luaChon1 = sc.nextInt();
                        switch (luaChon1) {
                            case (1):
                                sc.nextLine();
                                System.out.print("\nNhap thong tin hang hoa:");
                                do {
                                    dSHH.them(nhapHangHoa());
                                    System.out.print("\nBan co muon them tiep khong?(Y/N): ");
                                    nhapTiep = sc.nextLine();
                                } while (nhapTiep.equalsIgnoreCase("Y"));
                                break;
                            case (2):
                                System.out.println("**************** Danh sach hang hoa ****************");
                                dSHH.inDS();
                                System.out.println("****************************************************");
                                break;
                            case (3):
                                sc.nextLine();
                                System.out.print("Nhap ma cua hang hoa muon sua: ");
                                String mHSua = sc.nextLine();
                                System.out.print("Nhap thong tin hang hoa sua: ");
                                dSHH.SuaHH(mHSua, nhapHangHoa());
                                break;
                            case (4):
                                sc.nextLine();
                                System.out.print("Nhap ma cua hang hoa muon xoa: ");
                                String mHXoa = sc.nextLine();
                                dSHH.xoaTheoMaHH(mHXoa);
                                break;
                            case (5):
                                sc.nextLine();
                                System.out.print("Nhap ten cua hang hoa muon xoa: ");
                                String tenXoa = sc.nextLine();
                                dSHH.xoaTheoTenHH(tenXoa);
                                break;

                        }

                    } while (luaChon1 != 0);
                    break;
                case (2):
                    int luaChon2;
                    do {
                        System.out.println("********************** Tra cuu *********************");
                        System.out.println("**  1.Tim hang hoa theo ma hang                   **");
                        System.out.println("**  2.Tim hang hoa theo ten hang                  **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon :");
                        luaChon2 = sc.nextInt();
                        switch (luaChon2) {
                            case (1):
                                sc.nextLine();
                                System.out.print("Nhap ma cua hang hoa can tim: ");
                                System.out.println(dSHH.timHHTheoMa(sc.nextLine()));
                                break;
                            case (2):
                                sc.nextLine();
                                System.out.print("Nhap ten cua hang hoa can tim: ");
                                System.out.println(dSHH.timHHTHeoTen(sc.nextLine()));
                                break;
                        }

                    } while (luaChon2 != 0);
                    break;
                case (3):
                    int luaChon3;
                    do {
                        System.out.println("**************** Bao cao - thong ke ****************");
                        System.out.println("**  1.In danh sach theo don gia giam dan          **");
                        System.out.println("**  2.Thong ke so luong hang hoa                  **");
                        System.out.println("**  3.Thong ke don gia hang hoa                   **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon :");
                        luaChon3 = sc.nextInt();
                        switch (luaChon3) {
                            case (1):
                                dSHH.sapXepTHeoDonGiaGiamDan();
                                System.out.println("************ Danh sach hang hoa giam dan don gia ***********");
                                dSHH.inDS();
                                System.out.println("************************************************************");
                                break;
                            case (2):
                                dSHH.thongkeSLHH();
                                break;
                            case (3):
                                dSHH.thongKeDGHH();
                                break;
                        }

                    } while (luaChon3 != 0);
                    break;
                case (4):
                    int luaChon4;
                    do {
                        System.out.println("********************* Tien ich *********************");
                        System.out.println("**  1.Luu danh sach vao file                      **");
                        System.out.println("**  2.Lay danh sach tu file                       **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon :");
                        luaChon4 = sc.nextInt();
                        switch (luaChon4) {
                            case (1):
                                sc.nextLine();
                                System.out.print("Nhap ten file: ");
                                dSHH.ghiVaoFile(sc.nextLine());
                                break;
                            case (2):
                                sc.nextLine();
                                System.out.println("Nhap ten file: ");
                                dSHH.layTuFile(sc.nextLine());
                                break;
                        }

                    } while (luaChon4 != 0);
                    break;
            }

        } while (luaChon != 0);
    }

    public static HangHoa nhapHangHoa() {
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
