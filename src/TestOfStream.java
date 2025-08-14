import java.io.*;
import java.util.Scanner;

class Customer implements Serializable {
    String cusID;
    String name;
    String phonNo;
    static int count = 1;

    Customer() {
    }

    Customer(String n, String p) {
        // FIXED: Added count++ so that cusID increments for each customer
        cusID = "c" + count++;
        name = n;
        phonNo = p;
    }

    public String toString() {
        return cusID + " " + name + " " + phonNo;
    }
}

public class TestOfStream {
    public static void main(String[] args) {
        // First task: Storing a float type array in a file and read it
        float[] f = {5.3f, 6.3f, 6.23f, 2.3f, 56.2f};

        try {
            // -------------------------- Storing a float array --------------------------
            /*
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test2.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(f.length);
            for (float list : f) {
                dos.writeFloat(list);
            }
            dos.close();
            fos.close();
            */

            // -------------------------- Reading float array --------------------------
            /*
            FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Test2.txt");
            DataInputStream dis = new DataInputStream(fis);
            int j = dis.readInt();
            for (int i = 0; i < j; i++) { // FIXED: Changed from i=1 to i=0
                System.out.println(dis.readFloat());
            }
            fis.close();
            dis.close();
            */

            // -------------------------- Second task: Store Customer objects --------------------------
            /*
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Customer.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Customer[] list = {
                    new Customer("Umang", "89556503323"),
                    new Customer("Ram", "8955650582154"),
                    new Customer("Sham", "8955652635213"),
                    new Customer("Sanu", "89556503323")
            };
            oos.writeInt(list.length);
            for (Customer c : list) {
                oos.writeObject(c);
            }
            oos.close();
            fos.close();
            */

            // -------------------------- Reading Customer objects --------------------------
            Scanner sc = new Scanner(System.in);
            FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/Customer.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int length = ois.readInt();
            Customer[] list = new Customer[length];

            // FIXED: Array index should start at 0, not 1
            for (int i = 0; i < length; i++) {
                list[i] = (Customer) ois.readObject();
            }

            System.out.println("Enter the name: ");
            String s = sc.nextLine();

            // FIXED: Changed `name.equalsignoreCase` to `s.equalsIgnoreCase`
            for (int i = 0; i < length; i++) {
                if (s.equalsIgnoreCase(list[i].name)) {
                    System.out.println(list[i]);
                }
            }

            fis.close();
            ois.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
