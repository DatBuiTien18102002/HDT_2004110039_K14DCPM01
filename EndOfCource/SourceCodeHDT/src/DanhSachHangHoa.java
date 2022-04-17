import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DanhSachHangHoa {
    

    private List<HangHoa> danhSach = new ArrayList<>();
    private int tongSLHangDM=0,tongSLHangSS=0,tongSLHangTP=0;
    private int tongDGHH=0,tongDGHangDM=0,tongDGHangSS=0,tongDGHangTP=0;

    public List<HangHoa> getDanhSachHH(){
        return danhSach;
    }

    public void setDanhSachHH(List<HangHoa> danhSach) {
        this.danhSach = danhSach;
    }




    public void them(HangHoa newHH) {
        for (HangHoa hangHoa : danhSach) {
            if(newHH.getMaHang().equalsIgnoreCase(hangHoa.getMaHang())){
                System.err.println("Ma hang da ton tai!!!");
                System.err.println("Them hang hoa khong thanh cong");
                return;
            }         
        }
        danhSach.add(newHH);
        System.out.println("Them hang hoa vao danh sach thanh cong");
    }

    public void inDS() {
        for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
        }
    }

    public void xoaTheoMaHH(String ma){
        if(timHHTheoMa(ma)==null){
            System.out.println("Xoa that bai!!");
            return;
        }else{
            danhSach.remove(timHHTheoMa(ma));
            System.out.println("Xoa thanh cong");
        }
    }
    public void xoaTheoTenHH(String ten) {
        if(timHHTHeoTen(ten)==null){
            System.out.println("Xoa that bai!!");
            return;
        }else{
            danhSach.remove(timHHTHeoTen(ten));
            System.out.println("Xoa thanh cong");
        }
    }

    
    
    public int timViTriHH(HangHoa hH) {
        int viTri = danhSach.indexOf(hH);
        return viTri;
        
    }
    public void SuaHH(String mH,HangHoa hH) {
        if(timHHTheoMa(mH)==null){
            System.out.println("Sua that bai!!");
            return;
        }else{
            danhSach.set(timViTriHH(timHHTheoMa(mH)), hH);
        }
    }
    
    public HangHoa timHHTheoMa(String ma) {
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa.getMaHang().trim().equalsIgnoreCase(ma)){
                return hangHoa;
            }
        }
        System.out.println("Khong tim thay hang hoa");
        return null;
    }
    public HangHoa timHHTHeoTen(String ten) {
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa.getTenHang().trim().equalsIgnoreCase(ten)){
                return hangHoa;
            }
        }
        System.out.println("Khong tim thay hang hoa");
        return null;
    }
    public void sapXepTHeoDonGiaGiamDan() {
        Comparator<HangHoa> sosanh = new Comparator<HangHoa>() {
        @Override
        public int compare(HangHoa o1, HangHoa o2) {
         return Double.compare(o2.getDonGia(), o1.getDonGia());
        }
         };
        danhSach.sort(sosanh);
    }


    public void thongkeSLHH() {
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa instanceof HangDienMay){
                tongSLHangDM++;
            }else if(hangHoa instanceof HangThucPham){
                tongSLHangTP++;
            }else{
                tongSLHangSS++;
            }
        }

        System.out.println("Tong so luong hang hoa: "+danhSach.size());
        System.out.println("Tong so luong hang Dien May: "+tongSLHangDM);
        System.out.println("Tong so luong hang Thuc Pham: "+tongSLHangTP);
        System.out.println("Tong so luong hang Sanh Su: "+tongSLHangSS);
    }

    public void thongKeDGHH() {
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa instanceof HangDienMay){
                tongDGHangDM += hangHoa.getDonGia()*hangHoa.getSoLuongTon();
            }else if(hangHoa instanceof HangThucPham){
                tongDGHangTP += hangHoa.getDonGia()*hangHoa.getSoLuongTon();
            }else{
                tongDGHangSS += hangHoa.getDonGia()*hangHoa.getSoLuongTon();
            }
            tongDGHH += hangHoa.getDonGia()*hangHoa.getSoLuongTon();
        }

        System.out.println("Tong don gia hang hoa: "+tongDGHH);
        System.out.println("Tong don gia hang Dien May: "+tongDGHangDM);
        System.out.println("Tong don gia hang Thuc Pham: "+tongDGHangTP);
        System.out.println("Tong don gia hang Sanh Su: "+tongDGHangSS);
    }
       
}
