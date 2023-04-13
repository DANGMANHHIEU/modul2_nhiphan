package ex1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFlie(File f1,File f2) throws IOException {
        Files.copy(f1.toPath(),f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileStream(File f1,File f2)throws IOException{
        InputStream is =null;
        OutputStream os=null;
        try{
            is=new FileInputStream(f1);
            os=new FileOutputStream(f2);
            byte[] buffer=new byte[1024];
            int length= is.read(buffer);
            while (length>0){
                os.write(buffer,0,length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter file 1:");
        String file1= sc.nextLine();
        System.out.println("Enter file 2:");
        String file2=sc.nextLine();

        File n1 =new File(file1);
        File n2 =new File(file2);

        try {
            copyFlie(n1,n2);
            //copyFileStream(n1,n2);
        }catch (IOException e){
            System.out.println("ko the copy file");
            System.out.println(e.getMessage());
        }

    }
}
