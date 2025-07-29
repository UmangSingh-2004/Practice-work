import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            // Open the file in read/write mode ("rw")
            RandomAccessFile rf = new RandomAccessFile("D:/Java/Java Language/java/Practice work/InterfacePractice/Data.txt", "rw");

            // Read the first byte and print it as a char
            // Pointer moves from position 0 → 1
            System.out.println((char) rf.read());

            // Read the next byte and print as a char
            // Pointer moves from position 1 → 2
            System.out.println((char) rf.read());

            // Read the next byte and print as a char
            // Pointer moves from position 2 → 3
            System.out.println((char) rf.read());

            // Write the character 'd' at current position (pos 3)
            // This overwrites the byte at position 3 with ASCII value of 'd'
            // Pointer moves from position 3 → 4
            rf.write('d');

            // Read the next byte from position 4 and print it
            // Pointer moves from position 4 → 5
            System.out.println((char) rf.read());

            // Skip 3 bytes ahead from current position (pos 5 → pos 8)
            rf.skipBytes(3);

            // Read the byte at position 8 and print
            // Pointer moves from position 8 → 9
            System.out.println((char) rf.read());

            // Move file pointer back to position 3 explicitly
            rf.seek(3);

            // Read the byte at position 3 (which was overwritten with 'd' earlier)
            // Pointer moves from position 3 → 4
            System.out.println((char) rf.read());

            // Print current file pointer position (should be 4 now)
            System.out.println(rf.getFilePointer());

            // Move pointer forward by 2 bytes from current position (pos 4 → pos 6)
            rf.seek(rf.getFilePointer() + 2);

            // Read byte at position 6 and print
            // Pointer moves from position 6 → 7
            System.out.println((char) rf.read());

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

/*
====================================================
📌 RANDOMACCESSFILE — EXPLANATION
====================================================

👉 What RandomAccessFile Does:
- Allows reading **and** writing to a file at **any position**.
- File pointer can be moved anywhere using `seek(position)`.
- Supports both **"r" (read-only)** and **"rw" (read/write)** modes.

👉 Where We Use RandomAccessFile:
- When we need to **update part of a file** without rewriting the whole file.
- Database-like files where records are fixed-length and can be accessed by position.
- Editing large binary/text files at specific locations.
- Building custom file formats that need both read and write in random order.

👉 Advantages:
1. **Read/Write anywhere** — move the pointer to any byte.
2. No need to load the whole file in memory.
3. Efficient for **large files** where only small parts need updating.
4. Supports both **binary** and **text** data.

👉 Key Points:
- `seek(position)` moves file pointer to absolute byte position.
- `getFilePointer()` returns the current pointer position.
- `read()` reads a byte; `readChar()` reads 2 bytes (UTF-16).
- `write()` writes bytes/chars at current pointer position.
- **Caution:** Overwrites existing bytes at that position.
- Works best when file structure is known (fixed positions, offsets).

Example Concept:
File Content:   [ H  e  l  l  o  \n ]
Byte Index:      0  1  2  3  4   5
Pointer:
   seek(2) → moves to 'l'
   write('X') → file becomes [ H  e  X  l  o  \n ]
====================================================
*/