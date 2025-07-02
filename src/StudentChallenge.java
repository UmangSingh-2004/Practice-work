import java.io.*;
public class StudentChallenge {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            String str = new String(b);
            String store = str;
            System.out.println(store);
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge.txt");
            byte[] d = store.getBytes();
            fos.write(b,0,str.length());
            fos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
