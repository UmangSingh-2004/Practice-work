import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("D:/Java/Java Language/java/Practice work/InterfacePractice/Data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
