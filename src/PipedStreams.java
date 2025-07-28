import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// Buyer thread reads data from a PipedInputStream
class Buyer extends Thread {
    PipedInputStream buyer;

    // Fix: Correct assignment. It was previously: n = buyer;
    Buyer(PipedInputStream n) {
        this.buyer = n;
    }

    //  Fix: Method name changed from 'Run()' to 'run()'
    // Thread's start() method internally calls run(), so correct naming is essential
    public void run() {
        try {
            int x;
            while (true) {
                x = buyer.read();  // Reading a byte from the pipe
                System.out.println("Buyer buying thing " + x);
                Thread.sleep(10);  // Simulate delay
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  //  Fix: Exception should be handled here instead of 'throws'
        }
    }
}

// Seller thread writes data to a PipedOutputStream
class Seller extends Thread {
    PipedOutputStream seller;

    //  Fix: Correct assignment. It was previously: n = seller;
    Seller(PipedOutputStream n) {
        this.seller = n;
    }

    //Method name run()
    public void run() {
        try {
            int count = 1;
            while (true) {
                seller.write(count);   // Writing a byte to the pipe
                seller.flush();        // Ensure data is sent immediately
                System.out.println("Seller selling thing " + count);
                Thread.sleep(10);      // Simulate delay
                count++;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PipedStreams {
    public static void main(String[] args) throws IOException {
        PipedInputStream pi = new PipedInputStream();
        PipedOutputStream po = new PipedOutputStream();

        pi.connect(po);  // Connect input and output streams for inter-thread communication

        Buyer b = new Buyer(pi);
        Seller s = new Seller(po);

        b.start();  //  Triggers the run() method inside Buyer
        s.start();  //  Triggers the run() method inside Seller
    }
}