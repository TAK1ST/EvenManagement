package eventmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import eventmanagement.models.Events;
import eventmanagement.utils.DateUtil;
import eventmanagement.utils.FileUtils;
import eventmanagement.utils.ValidatedInput;

public class Service {
	private static ArrayList<Events> EVENT_DATABASE = new ArrayList<>();
	private static String filename = "./data/eventsDatabase";
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
		Events event = new Events(id, name, eventDate, location, numberOfAttendees, status);

		// Add the event to the database
		EVENT_DATABASE.add(event);

		// Print event details
		System.out.println("Event ID: " + id);
		System.out.println("Event Name: " + name);
		System.out.println("Event Date: " + eventDate);
		System.out.println("Event Location: " + location);
		System.out.println("Number of Attendees: " + numberOfAttendees);
		System.out.println("Event Status: " + status);

		// Save the updated event database
		FileUtils.saveFileObject(filename, EVENT_DATABASE);
	}

}
