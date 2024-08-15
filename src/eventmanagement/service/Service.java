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
        String name = ValidatedInput.getName();
        LocalDate eventDate = DateUtil.inputEventDate(sc);
        String location = ValidatedInput.getLocation();
        int numberOfAttendees = ValidatedInput.numberOfAttendence();
        boolean status = ValidatedInput.inputStatus(sc);

        // Create an Event object
        Events newEvent = new Events(id, name, eventDate, location, numberOfAttendees, status);

        // Add the event to the database
        EVENT_DATABASE.add(newEvent);

        // Save the updated event database
        Menu.saveToFile();
    }

}
