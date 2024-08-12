package eventmanagement.service;

import java.time.LocalDate;
import java.util.Scanner;

import eventmanagement.utils.DateUtil;
import eventmanagement.utils.ValidatedInput;

public class Service {

	// create new Event
	public static void createEvent() {
		Scanner sc = new Scanner(System.in); 
		int id = ValidatedInput.getID();
		String name=ValidatedInput.getName(sc);
		LocalDate eventDate = DateUtil.inputEventDate(sc);
		String location = ValidatedInput.getLocation(sc);
		int number_of_attendees = ValidatedInput.numberOfAttendence(sc);
		boolean status = ValidatedInput.inputStatus(sc);

		//print id
		System.out.println(id);

		//print name
		System.out.println("Enter name:"+name);
		
		// Print eventDate
		System.out.println(eventDate);

		// print location
		System.out.println("Enter location:" + location);


		// print number of attendees
		System.out.println(number_of_attendees);

		// print status
		System.out.println(status);
	}
}
