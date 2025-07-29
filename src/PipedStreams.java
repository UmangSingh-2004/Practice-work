import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// Buyer thread: continuously reads data from the PipedInputStream
class Buyer extends Thread {
    PipedInputStream buyer;
    Buyer(PipedInputStream n) {
        this.buyer = n;
    }
    public void run() {
        try {
            int x;
            while (true) {
                x = buyer.read();                     // Receive one byte from the pipe
                System.out.println("Buyer buying thing " + x);
                Thread.sleep(10);                     // Small delay to simulate processing
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();                      // Print stack trace if an error occurs
        }
    }
}

// Seller thread: continuously writes data into the PipedOutputStream
class Seller extends Thread {
    PipedOutputStream seller;
    Seller(PipedOutputStream n) {
        this.seller = n;
    }
    public void run() {
        try {
            int count = 1;
            while (true) {
                seller.write(count);                  // Send one byte through the pipe
                seller.flush();                       // Ensure the byte is immediately pushed
                System.out.println("Seller selling thing " + count);
                Thread.sleep(10);                     // Small delay to simulate production time
                count++;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();                      // Print stack trace if an error occurs
        }
    }
}

public class PipedStreams {
    public static void main(String[] args) throws IOException {
        // Create piped input and output streams for communication between threads
        PipedInputStream pi = new PipedInputStream();
        PipedOutputStream po = new PipedOutputStream();

        // Connect the streams to allow data flow between Seller and Buyer
        pi.connect(po);

        // Create and start Buyer and Seller threads
        Buyer b = new Buyer(pi);
        Seller s = new Seller(po);

        b.start();
        s.start();
    }
}
/*
====================================================
        📌 PIPED STREAMS — EXPLANATION
====================================================

        👉 What Piped Streams Do:
        - `PipedInputStream` and `PipedOutputStream` (or Reader/Writer equivalents)
        allow **two threads** to communicate directly.
        - Data written to the PipedOutputStream is immediately available
        for reading from the connected PipedInputStream.

        👉 Where We Use Piped Streams:
        - **Producer-Consumer pattern** (one thread produces data, another consumes it).
        - **Inter-thread communication** without using files or sockets.
        - Useful for **real-time streaming of data** between threads.

        👉 Advantages:
        1. **Thread-to-thread communication without intermediate storage** (no file needed).
        2. **Fast** because it’s all in memory.
        3. Avoids manual synchronization of data queues in basic scenarios.

        👉 Key Points:
        - You must connect `PipedOutputStream` to `PipedInputStream` using `connect()` or constructor.
        - Data moves **one-way**: Output → Input.
        -  Typically used between **exactly two threads**.
        - Not suitable for large buffering; intended for streaming small chunks.
        - If both streams are used in the same thread, it can cause a **deadlock**.

        Example Concept:
        [Thread 1: Seller] ---> writes data ---> [PipedOutputStream]
        connected to
        [Thread 2: Buyer ] <--- reads data  <--- [PipedInputStream]
========================================================================================================
*/