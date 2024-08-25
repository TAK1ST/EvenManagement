package eventmanagement.service;

import eventmanagement.Menu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import eventmanagement.models.Events;
import eventmanagement.utils.DateUtil;
import eventmanagement.utils.ValidatedInput;
import eventmanagement.utils.validOutput;

public class Service {

    public static ArrayList<Events> EVENT_DATABASE = new ArrayList<>();
    public static String filename = "data/EventsData.txt";
    public static final Scanner sc = new Scanner(System.in);
// Method to create and save a new Event

    public static void createEvent() {

        System.out.println("CREATE NEW EVENT");
        // Collect event details
        int id = ValidatedInput.getID();
        String name = ValidatedInput.getName();
        LocalDate eventDate = DateUtil.inputEventDate(sc);
        String location = ValidatedInput.getLocation();
        int numberOfAttendees = ValidatedInput.numberOfAttendence();
        String status = ValidatedInput.inputStatus();

        // Create an Event objects
        Events newEvent = new Events(id, name, eventDate, location, numberOfAttendees, status);

        // Add the event to the database
        EVENT_DATABASE.add(newEvent);

        // Save the updated event database
        Menu.saveToFile();
    }

    public static String searchEvent() {
        System.out.println("Enter part of the event name to search:");
        String input = validOutput.getString(sc); // Get user input
        StringBuilder result = new StringBuilder();

        for (Events event : EVENT_DATABASE) {
            if (event.getName().toLowerCase().contains(input.toLowerCase())) {
                result.append(event.getName()).append("\n"); // Append event details to the result
            }
        }

        if (result.length() > 0) {
            System.out.println("Found events:\n" + result.toString()); // Print all found events
            return result.toString();
        } else {
            System.out.println("No events found containing: " + input);
            return null;
        }
    }

    public static boolean checkExist(String eventName) {
        for (Events event : EVENT_DATABASE) {
            if (eventName.equalsIgnoreCase(event.getName())) {
                return true; // Event exists
            }
        }
        return false; // Event does not exist
    }

    public static void checkEventExist() {
        System.out.print("Enter event name: ");
        String subString = sc.nextLine();
        if (checkExist(subString)) {
            System.out.println("Event Exist");
        } else {
            System.out.println("Event does not Exist");
        }
    }

    public static void updateEvent() {
        int choice;
        do {
            System.out.println("1. Edit Event");
            System.out.println("2. Delete Event");
            System.out.println("3. Back to menu");
            choice = Menu.getEventOption();
            switch (choice) {
                case 1:
                    editEvent();
                    break;
                case 2:
                    deleteEvent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; // Exits the updateEvent method and returns to the menu
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } while (choice != 3);
    }

    public static void editEvent() {
        System.out.println("Enter event name to edit or type 'back' to return to menu:");
        String input = sc.next(); // Get user input
        if ("back".equalsIgnoreCase(input)) {
            return; // Exits editEvent method and returns to the previous menu
        }

        if (checkExist(input)) {
            for (Events event : EVENT_DATABASE) {
                if (input.equalsIgnoreCase(event.getName())) {
                    System.out.println(event); // Print the event details
                    // Add editing logic here
                    break;
                }
            }
        } else {
            System.out.println("Event does not exist.");
        }
    }

    public static void deleteEvent() {
        System.out.println("Enter event name to delete or type 'back' to return to menu:");
        String input = sc.next(); // Get user input
        if ("back".equalsIgnoreCase(input)) {
            return; // Exits deleteEvent method and returns to the previous menu
        }

        if (checkExist(input)) {
            for (Events event : EVENT_DATABASE) {
                if (event.getName().toLowerCase().contains(input.toLowerCase())) {
                    System.out.println("Deleting event: " + event.getName());
                    // Add deletion logic here
                    break;
                }
            }
        } else {
            System.out.println("Event does not exist.");
        }
    }
}
