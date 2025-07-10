import java.io.ByteArrayInputStream;

public class ByteArrayInputOutputExample {
    public static void main(String[] args) {
        try{
            byte[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
        //how to use Byte Array Input Stream:-
        //first make object of ByteArrayInputStream
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        //there is two type of reading elements of ByteArrayInputStream
        //1.using while loop:
//        int x;
//        while ((x = bais.read()) != -1) {
//            System.out.print((char) x);
//        }
//        bais.close();
        //2.using .readall()
        String str = new String(bais.readAllBytes());
        System.out.println(str);

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
