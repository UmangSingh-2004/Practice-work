import java.io.File;
import java.util.Arrays;

public class FileClassExample {
    public static void main(String[] args) {
        // Creating a File object pointing to a directory
        File f = new File("D:/Java/Java Language/java/Practice work/InterfacePractice");

        // Checks if the given path is a directory
        System.out.println(f.isDirectory());

        // Returns an array of file/directory names (String)
        System.out.println(Arrays.toString(f.list()));

        // Returns an array of File objects (with path info)
        File[] strint = f.listFiles();
        for (File x : strint) {
            // Print file or folder name
            System.out.println(x.getName() + " ");
            // Print full path
            System.out.println(x.getPath());
        }

        // Creating File object pointing to a specific file
        File f1 = new File("D:/Java/Java Language/java/Practice work/InterfacePractice/You.txt");

        // Checks if the file is hidden
        f1.isHidden();
    }
}

/*
     ======================================
     ALL METHODS OF java.io.File CLASS
     ======================================

     ─── File/Directory Creation & Deletion ───
     boolean createNewFile()                → Creates a new file
     boolean mkdir()                        → Creates a single directory
     boolean mkdirs()                       → Creates directory and all parent directories
     boolean delete()                       → Deletes the file or directory
     void deleteOnExit()                    → Deletes file on JVM exit

     ─── File Info / Property Methods ───
     String getName()                       → Gets name of file or directory
     String getPath()                       → Gets relative path
     String getAbsolutePath()              → Gets absolute path
     File getAbsoluteFile()                → Gets File object of absolute path
     String getCanonicalPath()             → Gets unique/clean path (no "..", ".", symlinks)
     File getCanonicalFile()               → Gets File object of canonical path
     String getParent()                    → Gets parent directory path
     File getParentFile()                  → Gets parent as a File object
     long length()                         → Gets size of file in bytes
     long lastModified()                   → Gets last modified time (ms)

     ─── File/Directory Checks ───
     boolean exists()                      → Checks if file/directory exists
     boolean isFile()                      → Checks if it's a file
     boolean isDirectory()                 → Checks if it's a directory
     boolean isAbsolute()                  → Checks if path is absolute
     boolean isHidden()                    → Checks if hidden

     ─── Permission Checks ───
     boolean canRead()                     → Checks if file is readable
     boolean canWrite()                    → Checks if file is writable
     boolean canExecute()                  → Checks if file is executable
     boolean setReadable(boolean)          → Sets read permission
     boolean setWritable(boolean)          → Sets write permission
     boolean setExecutable(boolean)        → Sets execute permission

     ─── Listing Contents ───
     String[] list()                       → Lists file names in directory
     File[] listFiles()                    → Lists File objects in directory
     String[] list(FilenameFilter filter)  → Lists files with filter
     File[] listFiles(FileFilter filter)   → Lists File objects with filter
     File[] listFiles(FilenameFilter)      → List files with name filter

     ─── Comparison & Sorting ───
     int compareTo(File pathname)          → Compares two File objects
     boolean equals(Object obj)            → Checks equality
     int hashCode()                        → Returns hashcode

     ─── File Path Utilities ───
     URI toURI()                           → Converts to URI
     Path toPath()                         → Converts to java.nio.file.Path
     String toString()                     → Returns pathname string

     ─── File Operations ───
     boolean renameTo(File dest)           → Renames or moves the file
     static File createTempFile(...)       → Creates temporary file

*/