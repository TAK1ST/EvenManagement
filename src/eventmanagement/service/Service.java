package eventmanagement.service;

import java.time.LocalDate;
import java.util.Scanner;

import eventmanagement.utils.ValidatedInput;

public class Service {
	// create new Event
	public static void createEvent(Scanner sc) {
		int id = 0;
		String name;
		LocalDate eventDate = ValidatedInput.inputEventDate();
		String location;
		int number_of_attendees;
		boolean status = ValidatedInput.inputStatus();
		while (true) {
			// need to fix id
			System.out.println("Enter id:" + id);

			System.out.println("Enter name:");
			name = sc.nextLine();
			if (name == null) {
				continue;
			}

			// Print formatted eventDate
			System.out.println(eventDate);

			System.out.println("Enter location:");
			location = sc.nextLine();
			if (location == null) {
				continue;
			}

			System.out.println("Enter number_of_attendees :");
			number_of_attendees = sc.nextInt();
			if (number_of_attendees <= 0) {
				continue;
			}
			//print status
			System.out.println(status);
			
		}
	}
}
