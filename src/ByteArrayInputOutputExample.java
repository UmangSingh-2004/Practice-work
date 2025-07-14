import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayInputOutputExample {
    public static void main(String[] args) {
        try{
            byte[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
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
        //how to make a ByteArrayOutputStream
//       for this we did not pass any think in constructor we only pass size which we want to pass in byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream(9);
        baos.write('a');
        baos.write('b');
        baos.write('c');
        baos.write('d');
        baos.write('e');
        baos.write('f');
        baos.write('g');
        baos.write('j');
        baos.write('k');

        byte[] a= baos.toByteArray();
        for (int x : a){
            System.out.print((char) x+",");
        }



        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
