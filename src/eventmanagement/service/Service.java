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


// Method to create and save a new Event
    public static void createEvent() {
        Scanner sc = new Scanner(System.in);

        // Collect event details
        int id = ValidatedInput.getID();
        String name = ValidatedInput.getName(sc);
        LocalDate eventDate = DateUtil.inputEventDate(sc);
        String location = ValidatedInput.getLocation(sc);
        int numberOfAttendees = ValidatedInput.numberOfAttendence(sc);
        boolean status = ValidatedInput.inputStatus(sc);

        // Create an Event object
        Events newEvent = new Events(id, name, eventDate, location, numberOfAttendees, status);

        // Add the event to the database
        EVENT_DATABASE.add(newEvent);

        // Print event details
        System.out.println("Event ID: " + id);
        System.out.println("Event Name: " + name);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Location: " + location);
        System.out.println("Number of Attendees: " + numberOfAttendees);
        System.out.println("Event Status: " + status);

        // Save the updated event database
        Menu.saveToFile();
    }

}
