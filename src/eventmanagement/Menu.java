package eventmanagement;

import eventmanagement.models.Events;
import java.util.Scanner;
import static eventmanagement.service.Service.EVENT_DATABASE;
import static eventmanagement.service.Service.filename;
import eventmanagement.utils.FileUtils;
import static eventmanagement.utils.FileUtils.loadFileObject;
import eventmanagement.utils.validOutput;
import java.util.ArrayList;

public class Menu {

    public static void displayMainMenu() {
        System.out.println("####################################");
        System.out.println("#          Main Menu               #");
        System.out.println("#----------------------------------#");
        System.out.println("# 1. Create a new event            #");
        System.out.println("# 2. An Event Exists               #");
        System.out.println("# 3. Search Event Information      #");
        System.out.println("# 4. Update Event                  #");
        System.out.println("# 5. Save to File                  #");
        System.out.println("# 6. Print List from File          #");
        System.out.println("# 7. End                           #");
        System.out.println("####################################");
        System.out.print("Choose an option (1-7)\n");
    }

    private static final Scanner sc = new Scanner(System.in);

    public static int getEventOption() {
        while (true) {
            System.out.print("Your select: ");
            String input = validOutput.getString(sc);

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            } else {
            }

            if (!input.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Number is too large. Please enter a smaller number.");
            }
        }
    }

    public static void printListEvent() {

        for (int i = 0; i < 100; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.println(
                "id                  name                date"
                + "                location             attendence"
                + "          status");
        for (int i = 0; i < 100; i++) {
            System.out.print("_");
        }
        System.out.println("");
        for (Events event : EVENT_DATABASE) {
            System.out.println(event.getId() + validOutput.padSpaces(event.getId(), 24)
                    + event.getName() + validOutput.padSpaces(event.getName(), 24)
                    + event.getEventDate() + validOutput.padSpaces(event.getEventDateAsString(), 24)
                    + event.getLocation() + validOutput.padSpaces(event.getLocation(), 24)
                    + event.getNumber_of_attendees() + validOutput.padSpaces(Integer.toString(event.getNumber_of_attendees()), 24)
                    + event.getStatus()+ validOutput.padSpaces(String.valueOf(event.getStatus()), 24)
            );
        }
    }

    public static void saveToFile() {
        FileUtils.saveFileObject(filename, EVENT_DATABASE);
    }

    public static void loadEventFromFile() {
        EVENT_DATABASE = (ArrayList<Events>) loadFileObject(filename);
    }

}
