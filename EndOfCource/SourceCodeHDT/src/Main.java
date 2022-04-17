public class Main {
    public static void main(String[] args) {
        DanhSachHangHoa dSHH = new DanhSachHangHoa();
        XuLyFile xuLy = new XuLyFile();
        ConsoleInputing consoleInputing = new ConsoleInputing();
        String nhapTiep = null;
        int luaChon;
        xuLy.layTuFile("danhsachhanghoa.dat", dSHH);
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
            luaChon = consoleInputing.getNhap().nextInt();
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
                        luaChon1 = consoleInputing.getNhap().nextInt();
                        switch (luaChon1) {
                            case (1):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("\nNhap thong tin hang hoa:");
                                do {
                                    dSHH.them(consoleInputing.nhapHangHoa());
                                    System.out.print("\nBan co muon them tiep khong?(Y/N): ");
                                    nhapTiep = consoleInputing.getNhap().nextLine();
                                } while (nhapTiep.equalsIgnoreCase("Y"));
                                break;
                            case (2):
                                System.out.println("**************** Danh sach hang hoa ****************");
                                dSHH.inDS();
                                System.out.println("****************************************************");
                                break;
                            case (3):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ma cua hang hoa muon sua: ");
                                String mHSua = consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap thong tin hang hoa sua: ");
                                dSHH.SuaHH(mHSua, consoleInputing.nhapHangHoa());
                                break;
                            case (4):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ma cua hang hoa muon xoa: ");
                                String mHXoa = consoleInputing.getNhap().nextLine();
                                dSHH.xoaTheoMaHH(mHXoa);
                                break;
                            case (5):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ten cua hang hoa muon xoa: ");
                                String tenXoa = consoleInputing.getNhap().nextLine();
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
                        luaChon2 = consoleInputing.getNhap().nextInt();
                        switch (luaChon2) {
                            case (1):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ma cua hang hoa can tim: ");
                                System.out.println(dSHH.timHHTheoMa(consoleInputing.getNhap().nextLine()));
                                break;
                            case (2):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ten cua hang hoa can tim: ");
                                System.out.println(dSHH.timHHTHeoTen(consoleInputing.getNhap().nextLine()));
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
                        luaChon3 = consoleInputing.getNhap().nextInt();
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
                        luaChon4 = consoleInputing.getNhap().nextInt();
                        switch (luaChon4) {
                            case (1):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ten file: ");
                                xuLy.ghiVaoFile(consoleInputing.getNhap().nextLine(), dSHH);
                                break;
                            case (2):
                                consoleInputing.getNhap().nextLine();
                                System.out.print("Nhap ten file: ");
                                xuLy.layTuFile(consoleInputing.getNhap().nextLine(), dSHH);
                                break;
                        }

                    } while (luaChon4 != 0);
                    break;
            }

        } while (luaChon != 0);
    }


}
