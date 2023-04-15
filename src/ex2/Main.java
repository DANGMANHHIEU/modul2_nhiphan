package ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void write(String path, List<Students>students){
        try {
            FileOutputStream os=new FileOutputStream(path);
            ObjectOutputStream oss=new ObjectOutputStream(os);
            oss.writeObject(students);
            os.close();
            oss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
     public static List<Students> read(String path){
        List<Students>students=new ArrayList<>();
        try {
            FileInputStream is=new FileInputStream(path);
            ObjectInputStream iss=new ObjectInputStream(is);
            students=(List<Students>) iss.readObject();
            is.close();
            iss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
     }

    public static void main(String[] args) {
        List<Students>students=new ArrayList<>();
        students.add(new Students(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Students(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Students(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Students(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Students(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        write("student.txt",students);

        List<Students> students1 = read("student.txt");
        for (Students s:students1){
            System.out.println(s);
        }

    }
}
