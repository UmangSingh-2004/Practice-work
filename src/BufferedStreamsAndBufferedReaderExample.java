import java.io.*;

public class BufferedStreamsAndBufferedReaderExample {
    public static void main(String[] args) {
        try {
            //Making a FileInputStream object with file part name
//            FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge2.txt");
//            //After that, we can create BufferedInputStream object and pass the object of FileInputStream
//            BufferedInputStream bis = new BufferedInputStream(fis);
            //use of mark() and reset()
//            System.out.print((char)bis.read());
//            System.out.print((char)bis.read());
//            System.out.print((char)bis.read());
//            System.out.print((char)bis.read());
//            System.out.print((char) bis.read());
//            System.out.print((char) bis.read());
//            bis.mark(10);
//            System.out.print((char)bis.read());
//            System.out.print((char)bis.read());
//            bis.reset();
//            System.out.print((char)bis.read());
//            //for reading all the latter's use this
//            byte x;
//            while ((x= (byte) bis.read()) != -1){
//                System.out.print((char) x);
//            }
//*-------------------------------------------------Buffered Input Stream----------------------------------------------------------------------------------*
//Making a FileInputStream object with file part name
            FileReader fis = new FileReader("D:/Java/Java Language/java/Practice work/InterfacePractice/Challenge2.txt");
            //After that, we can create BufferedInputStream object and pass the object of FileInputStream
            BufferedReader bis = new BufferedReader(fis);
            //use of mark() and reset()
            System.out.print((char)bis.read());
            System.out.print((char)bis.read());
            System.out.print((char)bis.read());
            System.out.print((char)bis.read());
            System.out.print((char) bis.read());
            System.out.print((char) bis.read());
            bis.mark(10);
            System.out.print((char)bis.read());
            System.out.print((char)bis.read());
            bis.reset();
            System.out.print((char)bis.read());
            // new method .readLine()
            //this is use for read all the lines in the stream
            System.out.println(bis.readLine());
//*-------------------------------------------------Buffered Reader Stream---------------------------------------------------------------------------------*
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            String str = "Learning Java Programming";
            bos.write(str.getBytes());
            bos.flush();
//*------------------------------------------------Buffered Output Stream-----------------------------------------------------------------------------------*
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}