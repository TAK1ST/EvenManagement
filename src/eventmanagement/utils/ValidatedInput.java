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
        while (name.length() < 5) {
            getName();
        }
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
        String location = validOutput.getString(sc);
        if (location.length() < 5) {
            System.out.println("location donot empty, please write address");
            getLocation();
        }
        return location;
    }

    // Check input status yes or no
    public static String inputStatus() {
        String inputStatus;

        while (true) {
            System.out.print("Is this event active (y/n):");
            inputStatus = validOutput.getString(sc);

            switch (inputStatus) {
                case "y":
                case "yes":
                    System.out.println("You entered: " + inputStatus);
                    return "Available"; // Event is active
                case "n":
                case "no":
                    System.out.println("You entered: " + inputStatus);

                    return "Not Available"; // Event is not active
                default:
                    System.out.println("Invalid input. Please enter 'y', 'yes', 'n', or 'no'.");
                    break;
            }
        }
    }
}
