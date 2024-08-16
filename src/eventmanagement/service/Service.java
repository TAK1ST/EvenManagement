package eventmanagement.service;

import eventmanagement.Menu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import eventmanagement.models.Events;
import eventmanagement.utils.DateUtil;
import eventmanagement.utils.ValidatedInput;

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

    public static void checkEventExist() {
        System.out.print("Enter event name: ");
        String subString = sc.nextLine();
        for (Events event : EVENT_DATABASE) {
            if (subString.equalsIgnoreCase(event.getName())) {
                System.out.println("Event Exist");
            }
            else System.out.println("Event does not Exist");
        }
    }
    //update tao them ham khi nhap sai -> nhap lai, 
    // neu khach khong muon nhap van co the thoat ra ve lai menu

}
