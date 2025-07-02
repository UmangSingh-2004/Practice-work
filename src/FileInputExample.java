import java.io.*;
public class FileInputExample {
    public static void main(String[] args){
        try (FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt")) {
            // first technique of reading file with the help of FileInputStream
            byte b[] = new byte[fis.available()];// 1. Create byte array of size equal to available bytes
            fis.read(b);// Read into byte array
            String str = new String(b);// 3. Convert the empty byte array to String
            System.out.println(str);// 4. Print the string
            // Second technique of reading file
            int x ;
            while ((x=fis.read())!=-1){// Loop until end of file (read() returns -1 when no more data)
                System.out.print(x);//printing the file words
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

