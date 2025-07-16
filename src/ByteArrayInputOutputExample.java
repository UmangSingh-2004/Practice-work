import java.io.*;

public class ByteArrayInputOutputExample {
    public static void main(String[] args) {
        try {
//            byte[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
            //how to use Byte Array Input Stream:-
            //first make object of ByteArrayInputStream
//        ByteArrayInputStream bais = new ByteArrayInputStream(b);
            //there is two type of reading elements of ByteArrayInputStream
            //1.using while loop:
//        int x;
//        while ((x = bais.read()) != -1) {
//            System.out.print((char) x);
//        }
//        bais.close();
            //2.using .readall()
//        String str = new String(bais.readAllBytes());
//        System.out.println(str);

//(----------------------------------------------------------------------------------------------------------------------------------------------------------)

            //how to make a ByteArrayOutputStream
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(9);
            //for this we did not pass any think in constructor we only pass size which we want to pass in byte array
            //for write byte by byte value we can use .write()
//        baos.write('a');
//        baos.write('b');
//        baos.write('c');
//        baos.write('d');
//        baos.write('e');
//        baos.write('f');
//        baos.write('g');
//        baos.write('j');
//        baos.write('k');
//for printing all the characters
//        byte[] a= baos.toByteArray();
//        for (int x : a){
//            System.out.print((char) x+",");
//        }
//for writing inside a file
//            baos.writeTo(new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt"));

//(---------------------------------------------------------------------------------------------------------------------------------)

            //CharArrayReadr is same as ByteArrayInputStream
//            char [] b = {'A','B','C','D','E','F'};
//            CharArrayReader crr = new CharArrayReader(b);
//            int x;
//            while ((x = crr.read()) != -1){
//                System.out.println((char) x);
//            }

            //(------------------------------------------------------------------------------------)

            //CharArrayWriter is same as ByteArrayOutputStream
            CharArrayWriter caw = new CharArrayWriter(6);
            caw.write('A');
            caw.write('B');
            caw.write('C');
            caw.write('D');
            caw.write('E');
            caw.write('F');
            caw.write('G');
            caw.write('H');
            caw.write('J');
            FileWriter fw = new FileWriter("D:/Java/Java Language/java/Practice work/InterfacePractice/Test.txt");
            caw.writeTo(fw);
            fw.flush();  // Important
            fw.close();  // Important
            caw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
