package eventmanagement.service;

import java.time.LocalDate;
import java.util.Scanner;

import eventmanagement.utils.DateUtil;
import eventmanagement.utils.ValidatedInput;

public class Service {
	private static String name;
	private static String location;

	// create new Event
	public static void createEvent(Scanner sc) {
		int id = ValidatedInput.getID();
		name = null;
		LocalDate eventDate = DateUtil.inputEventDate();
		location = null;
		Integer number_of_attendees = ValidatedInput.numberOfAttendence(sc);
		boolean status = ValidatedInput.inputStatus();
		System.out.println("Event id:" + id);

		System.out.println("Enter name:");
		if (name == null)
		{
			name = sc.nextLine();
		}

		// Print eventDate
		System.out.println(eventDate);

		// print location
		System.out.println("Enter location:");
		if (location == null)
		{
			location = sc.nextLine();
		}

		// print number of attendees
		System.out.println("Enter number_of_attendees :");
		System.out.println(number_of_attendees);

		// print status
		System.out.println(status);

	}
}
