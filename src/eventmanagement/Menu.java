package eventmanagement;

import java.util.Scanner;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("####################################");
        System.out.println("#         Main Menu:               #");
        System.out.println("#----------------------------------#");
        System.out.println("# 1. Create a new event            #");
        System.out.println("# 2. An Event Exists               #");
        System.out.println("# 3. Search Event Information      #");
        System.out.println("# 4. Update Event                  #");
        System.out.println("# 5. Save to File                  #");
        System.out.println("# 6. Print List from File          #");
        System.out.println("# 7. End                           #");
        System.out.println("####################################");
        System.out.print("Choose an option (1-7): ");
    }
    public static void getEventOption(Scanner sc) {
        // check boolean has int will true and return
        while (!sc.hasNextInt())
        {
            System.out.println("Invalid input. Please enter a nummber.");
            sc.nextInt();
        }
    }
}
