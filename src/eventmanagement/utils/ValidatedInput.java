package eventmanagement.utils;

import java.util.Random;
import java.util.Scanner;

public class ValidatedInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int getID() {
        int id;
        Random random = new Random();
        id = random.nextInt(100000);
        System.out.println("Event ID:" + id);
        return id;
    }

    public static String getName() {
        System.out.print("Enter name: ");
        String name = validOutput.getString(sc);
        do {
            if (name.length() < 5 )
            {
                System.out.println("Please enter event name at least 5 characters");
                getName();
            }
            else break;
            
        } while(true);

        return name;
    }

    public static int numberOfAttendence() {
        int Attended = 0; // Initialize to an invalid number to ensure it gets updated

        System.out.print("Enter number of attendance: ");
        try {
            Attended = Integer.parseInt(validOutput.getString(sc)); // Try to parse the input
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.next();
        }
        return Attended;
    }

    public static String getLocation() {
        System.out.print("Enter location: ");
        String name = validOutput.getString(sc);
        return name;
    }

    // Check input status yes or no
    public static boolean inputStatus(Scanner sc) {
        String inputStatus;

        while (true) {
            System.out.print("Is this event active (y/n):");
            inputStatus = validOutput.getString(sc);

            switch (inputStatus) {
                case "y":
                case "yes":
                    System.out.println("You entered: " + inputStatus);
                    return true; // Event is active
                case "n":
                case "no":
                    System.out.println("You entered: " + inputStatus);

                    return false; // Event is not active
                default:
                    System.out.println("Invalid input. Please enter 'y', 'yes', 'n', or 'no'.");
                    break;
            }
        }

    }

    public static String status(boolean inputStatus) {
        if (inputStatus == true) {
            return "Available";
        } else {
            return "Not Available";
        }
    }

}
