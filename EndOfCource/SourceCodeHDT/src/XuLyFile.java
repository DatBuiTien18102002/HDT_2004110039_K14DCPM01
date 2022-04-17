import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class XuLyFile {
    
    public void ghiVaoFile(String tenFile,DanhSachHangHoa dSHH){
        try {
            FileOutputStream outFile = new FileOutputStream(tenFile);
            
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            
            objOut.writeObject(dSHH.getDanhSachHH());
            System.out.println("Luu file thanh cong");
            objOut.close();           
        } catch (IOException e) {
        }
    }

    public void layTuFile(String tenFile, DanhSachHangHoa dSHH){
        try {
            FileInputStream inFile = new FileInputStream(tenFile);
            
            ObjectInputStream objIn = new ObjectInputStream(inFile);
            
            List<HangHoa> danhSach = (List) objIn.readObject();
            dSHH.setDanhSachHH(danhSach);
    
            System.out.println("Lay file thanh cong");
            objIn.close();           
        } catch (Exception e) {
        }
    }
}
