import java.io.*;  // Importing I/O classes for file and data streams

// Student class with 3 fields
class Student {
    int rollNo;
    String name;
    String subject;
}

public class DataStramExample {
    public static void main(String[] args) {
        try {
            // --------- Writing Data to File (DataOutputStream) ---------
            FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/DataStream.txt");  // Create a file output stream to the target file
            DataOutputStream dos = new DataOutputStream(fos);  // Wrapping FileOutputStream with DataOutputStream for writing primitive types

            Student s = new Student();  // Creating a Student object
            s.rollNo = 12;              // Setting roll number
            s.name = "Shon";            // Setting name
            s.subject = "CES";          // Setting subject

            dos.writeInt(s.rollNo);     // Writing rollNo as binary int (4 bytes)
            dos.writeUTF(s.name);       // Writing name as UTF string
            dos.writeUTF(s.subject);    // Writing subject as UTF string

            dos.close();  // Closing DataOutputStream
            fos.close();  // Closing FileOutputStream

            // --------- Reading Data from File (DataInputStream) ---------
            FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/DataStream.txt");  // Open file input stream to read the binary data
            DataInputStream dis = new DataInputStream(fis);  // Wrapping FileInputStream with DataInputStream for reading primitive types

            Student s1 = new Student();  // New Student object to hold data read from file
            s1.rollNo = dis.readInt();   // Reading int (must match the write order)
            s1.name = dis.readUTF();     // Reading UTF string (must match the write order)
            s1.subject = dis.readUTF();  // Reading UTF string (must match the write order)

            // Printing the read data to the console
            System.out.println("Name: " + s1.name +
                    " \nRoll No.: " + s1.rollNo +
                    " \nSubject: " + s1.subject);

            dis.close();  // Closing DataInputStream
            fis.close();  // Closing FileInputStream

        } catch (IOException e) {
            throw new RuntimeException(e);  // Handling file I/O exceptions
        }
    }
}

/*
-----------------------------------------------------
What is DataInputStream & DataOutputStream?
-----------------------------------------------------
- DataOutputStream: Used to write primitive data types (int, float, String, etc.) in binary format to an output stream.
- DataInputStream: Used to read primitive data types from a binary input stream.

-----------------------------------------------------
Where are Data Streams used?
-----------------------------------------------------
1. Binary file storage of structured data.
2. Sending primitive data over network sockets.
3. Efficient and compact data writing/reading.
4. When you need low-level control over data serialization.

-----------------------------------------------------
Common Mistakes:
-----------------------------------------------------
1. Reading in a different order than you wrote data (must match exactly).
2. Trying to open the binary file in a text editor expecting readable text.
3. Forgetting to close the streams (leads to resource leaks).
4. Using the wrong read method (like readInt when data is written as String).

-----------------------------------------------------
What's Fun/Advantage of Data Streams?
-----------------------------------------------------
1. Super-fast I/O because it's binary.
2. File sizes are much smaller compared to text formats.
3. You control how every byte is structured and read.
4. Useful for learning how serialization and protocols work internally.

-----------------------------------------------------
Key Methods of DataOutputStream used in this code:
-----------------------------------------------------
1. writeInt(int v)  -> Writes an integer (4 bytes).
2. writeUTF(String s) -> Writes a UTF-8 encoded string with a length prefix.
3. flush()          -> Flushes the stream to ensure all data is written.
4. close()          -> Closes the stream and releases resources.

-----------------------------------------------------
Key Methods of DataInputStream used in this code:
-----------------------------------------------------
1. readInt()        -> Reads 4 bytes and converts them to an integer.
2. readUTF()        -> Reads a UTF-8 string that was written using writeUTF().
3. close()          -> Closes the stream and releases resources.

-----------------------------------------------------
Other Common Methods:
-----------------------------------------------------
DataOutputStream:
- writeBoolean(boolean v)
- writeByte(int v)
- writeShort(int v)
- writeLong(long v)
- writeFloat(float v)
- writeDouble(double v)
- writeBytes(String s)
- writeChars(String s)

DataInputStream:
- readBoolean()
- readByte()
- readUnsignedByte()
- readShort()
- readUnsignedShort()
- readLong()
- readFloat()
- readDouble()
- readFully(byte[] b)
- skipBytes(int n)
- available()

-----------------------------------------------------
Remember:
- The order of reading must match the order of writing.
- Data is stored in binary, not plain text.
- Efficient for small-size, fast binary file operations.
-----------------------------------------------------
*/
