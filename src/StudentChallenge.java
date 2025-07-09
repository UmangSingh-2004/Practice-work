import java.io.*;
public class StudentChallenge {
    public static void main(String[] args) {
        try{
            FileInputStream fis1 = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            byte[] b = new byte[fis1.available()];
            fis1.read(b);
            String str = new String(b);
            String store = str;
            System.out.println(store);
            FileOutputStream fos1 = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge1.txt");
            byte[] d = store.getBytes();
            fos1.write(b,0,str.length());
            fos1.close();
            fis1.close();
            //2nd challenge:-
            FileInputStream fis2 = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            FileInputStream fis3 = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge1.txt");
            FileOutputStream fos2 = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge2.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
