import java.io.*;

// Student1 class implements Serializable interface to enable object serialization
class Student1 implements Serializable {
    private int rollno;
    private String name;
    private float avg;
    private String dept;

    public static int Data = 10;    // static field - belongs to class, not object (NOT serialized)
    public transient int t;         // transient field - will be skipped during serialization

    public Student1() {
        // No-arg constructor (not mandatory, but good practice during deserialization)
    }

    public Student1(int r, String n, float a, String d) {
        rollno = r;
        name = n;
        avg = a;
        dept = d;
        Data = 500;   // Changing static field
        t = 500;      // Transient value (won't be saved)
    }

    // Returns object information as a string
    public String toString() {
        return "\nStudent Details\n" +
                "\nRoll: " + rollno +
                "\nName: " + name +
                "\nAverage: " + avg +
                "\nDept: " + dept +
                "\nData (static): " + Data +      // Will print current value of class field
                "\nTransient (not saved): " + t + "\n"; // Will print 0 after deserialization
    }
}

public class ObjectStreamExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // ------------------ SERIALIZATION ------------------
//        FileOutputStream fos = new FileOutputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/ObjectStream.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//        Student1 s = new Student1(9, "Ram", 75.3f, "BA");  // Creating and initializing object
//        oos.writeObject(s);   // Serializing the object
//        fos.close();
//        oos.close();

        // ------------------ DESERIALIZATION ------------------
        FileInputStream fis = new FileInputStream("D:/Java/Java Language/java/Practice work/InterfacePractice/ObjectStream.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student1 s1 = (Student1) ois.readObject();  // Deserialize object
        System.out.println(s1);                     // Prints object (calls toString())

        ois.close();
        fis.close();
    }
}
/*
========================================================================================
📚 OBJECT STREAMS & JAVA SERIALIZATION – DEEP EXPLANATION
========================================================================================

🔷 WHAT IS SERIALIZATION?
Serialization = Converting a Java object into a byte stream (binary form) to:
- Save it to a file
- Send it over a network
- Persist object state (like caching or session saving)

Deserialization = Reconstructing the original object from that byte stream.

----------------------------------------------------------------------------------------
🧠 KEY CONCEPTS:
----------------------------------------------------------------------------------------
1. ✅ To enable serialization:
   ➤ Your class MUST implement: java.io.Serializable

2. ❌ What does NOT get serialized:
   ➤ Fields marked as **transient**
   ➤ **static** fields (they belong to class, not to object)
   ➤ Anything not Serializable (e.g., Thread, Socket, unless marked transient)

3. 📌 Serializable is a *marker interface*:
   ➤ It has NO methods.
   ➤ It just signals the JVM that the object is eligible for serialization.

4. ⚠️ Class versioning:
   ➤ Add this line to avoid compatibility issues:
      `private static final long serialVersionUID = 1L;`
   ➤ It's a unique ID used during deserialization to ensure class versions match.

----------------------------------------------------------------------------------------
🔑 METHODS IN OBJECT STREAM CLASSES:
----------------------------------------------------------------------------------------

ObjectOutputStream
------------------
- `writeObject(Object obj)`    → Serializes an object to the output stream
- `flush()`                    → Flushes the stream
- `close()`                    → Closes the stream

ObjectInputStream
------------------
- `readObject()`               → Reads and reconstructs the object
- `close()`                    → Closes the stream

----------------------------------------------------------------------------------------
🧪 EXAMPLE RESULTS (BEHAVIOR OF static & transient):
----------------------------------------------------------------------------------------

Original object created:
  - rollno = 9
  - name = "Ram"
  - avg = 75.3
  - dept = "BA"
  - static Data = 500
  - transient t = 500

After Deserialization:
  - rollno = 9
  - name = "Ram"
  - avg = 75.3
  - dept = "BA"
  - static Data = 10         (because static is not serialized; remains as class default)
  - transient t = 0          (because transient is skipped and default int = 0)

----------------------------------------------------------------------------------------
📦 WHEN TO USE OBJECT STREAMS?
----------------------------------------------------------------------------------------
✅ Desktop applications saving object state
✅ Simple backup/restore systems
✅ Java-only systems exchanging objects (RMI, caching)
✅ Writing object arrays or collections to files

----------------------------------------------------------------------------------------
⛔ WHEN NOT TO USE IT:
----------------------------------------------------------------------------------------
❌ If you want cross-language compatibility (use JSON/XML instead)
❌ If you’re building distributed microservices (use JSON, Protobuf, etc.)
❌ If you’re dealing with non-serializable types (like sockets or threads)

----------------------------------------------------------------------------------------
🧠 BONUS: SERIALIZING MULTIPLE OBJECTS
----------------------------------------------------------------------------------------
You can serialize a list:
    `oos.writeObject(new ArrayList<Student1>());`
And later:
    `ArrayList<Student1> list = (ArrayList<Student1>) ois.readObject();`

========================================================================================
🔥 INTERVIEW TIP:
========================================================================================
💬 Q: What happens if a class is not Serializable but you try to write it?
💬 A: Java throws **NotSerializableException**

💬 Q: What is serialVersionUID?
💬 A: A unique ID that ensures the class version used to serialize matches the one used to deserialize.
========================================================================================
*/
