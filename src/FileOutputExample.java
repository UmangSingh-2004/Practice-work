//1. import the FileOutputStream
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) {
        // 3. Adding all the thinks in the try and catch block
        try {
            //2. Making FileOutputStream object
             FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            //writing the string inside the file there are 2 types:-
            String str = "Learning Java Programming";
            //1. with the help of write() this push one by one
//            fos.write(str.getBytes());
            //1.(2) one by one with the help of for each loop
            byte[] b = str.getBytes();
//            for (byte x:b){
//                System.out.println(x);
//            }
            //2.with help of 3 write ()
            fos.write(b,0,str.length());
            //closing File Output Stream
            fos.close();
        }catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
