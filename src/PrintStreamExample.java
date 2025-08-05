import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// Class representing a Student with roll number, name, and subject
class Student {
    int rollNo;
    String name;
    String subject;
}

public class PrintStreamExample {
    public static void main(String[] args) {
        try {
            // Creating a FileOutputStream to write data into the specified file path
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/PrintStream.txt");

            // Wrapping the FileOutputStream with a PrintStream for formatted output
            PrintStream ps = new PrintStream(fos);

            // Creating a Student object and initializing its fields
            Student s1 = new Student();
            s1.rollNo = 10;
            s1.name = "Jone";
            s1.subject = "CES";

            // Writing Student details to the file using PrintStream
            ps.println(s1.rollNo);   // Writes roll number followed by a newline
            ps.println(s1.name);     // Writes name followed by a newline
            ps.println(s1.subject);  // Writes subject followed by a newline

            // It's a good practice to close the PrintStream to free resources
            ps.close();

        } catch (FileNotFoundException e) {
            // Handling the case when the file is not found or cannot be created
            throw new RuntimeException(e);
        }
    }
}
/*
----------------------------------------
What is PrintStream?
----------------------------------------
PrintStream is a class in java.io package used to write formatted representations of objects to a stream
(like a file, console, or byte array). It provides convenient methods to output data such as print(), println(), printf().

PrintStream handles exceptions internally and does not throw IOException, unlike other output streams.

----------------------------------------
Where is PrintStream used?
----------------------------------------
1. Writing formatted text data to files.
2. Redirecting console output (System.out) to a file.
3. Logging information.
4. Printing output to console (System.out is a PrintStream).

----------------------------------------
Main Methods of PrintStream:
----------------------------------------
1. print()   → Prints data without a newline.
2. println() → Prints data followed by a newline.
3. printf()  → Prints formatted data (like C's printf).
4. write()   → Writes raw byte data.
5. flush()   → Forces writing of buffered data.
6. close()   → Closes the stream and releases resources.
7. append()  → Appends character sequences.
----------------------------------------
*/