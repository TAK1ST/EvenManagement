package eventmanagement.utils;
import java.io.*;
public class FileUtils {
    public static Object loadFileObject(String filename) {
        filename = "./src/" + filename;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
    
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading object from file: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
        return null;
    }
    public static void saveFileObject(String filename, Object object) {
        filename = "./src/" + filename;
        try (FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
            {
                oos.writeObject(object);
            // No need to explicitly close the streams, try-with-resources handles it
            } catch(IOException e)
            {
                System.out.println("Error when save file.");
                e.printStackTrace();
            }
    }
}

