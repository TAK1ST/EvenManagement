package eventmanagement.utils;

import java.io.*;

public class FileUtils {

    public static Object loadFileObject(String filename) {
        filename = "./src/" + filename;
        File file = new File(filename);

        // Check if the file exists
        if (!file.exists()) {
            try {
                // If file doesn't exist, create a new one
                if (file.createNewFile()) {
                    System.out.println("File created: " + filename);
                } else {
                    System.out.println("Failed to create file: " + filename);
                }
                // Return null if the file was just created since no object can be loaded
                return null;
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return null;
            }
        } else {
            // If file exists, try to load the object
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return ois.readObject();
            } catch (EOFException e) {
                // Handle the case where the file is empty or reached its end unexpectedly
                System.out.println("File is empty or reached EOF unexpectedly: " + e.getMessage());
                return null;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void saveFileObject(String filename, Object object) {
        filename = "./src/" + filename;
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            System.out.println("saved sucessfully!!!");
            // No need to explicitly close the streams, try-with-resources handles it
        } catch (IOException e) {
            System.out.println("Error when save events to file:" + e.getMessage());
        }
    }
}
