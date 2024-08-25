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
        if (EVENT_DATABASE == null || EVENT_DATABASE.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        for (int i = 0; i < 150; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.println(
                "ID                  NAME                DATE"
                + "                LOCATION             ATTENDENCE"
                + "          STATUS");
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (Events event : EVENT_DATABASE) {
            System.out.println(event.getId() + validOutput.padSpaces(Integer.toString(event.getId()), 20)
                    + event.getName() + validOutput.padSpaces(event.getName(), 20)
                    + event.getEventDate() + validOutput.padSpaces(event.getEventDateAsString(), 20)
                    + event.getLocation() + validOutput.padSpaces(event.getLocation(), 20)
                    + event.getNumber_of_attendees() + validOutput.padSpaces(Integer.toString(event.getNumber_of_attendees()), 20)
                    + event.getStatus() + validOutput.padSpaces(event.getStatus(), 20)
            );
        }
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public static void saveToFile() {
        FileUtils.saveFileObject(filename, EVENT_DATABASE);
    }

    public static void loadEventFromFile() {
        EVENT_DATABASE = (ArrayList<Events>) loadFileObject(filename);
        if (EVENT_DATABASE == null) {
            EVENT_DATABASE = new ArrayList<>();
        }
    }
}
