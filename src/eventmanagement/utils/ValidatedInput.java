package eventmanagement.utils;

import java.util.Random;
import java.util.Scanner;

public class ValidatedInput {
	// check get ID
	public static int getID() {
		int id;
		Random random = new Random();
		id = random.nextInt(100000);
		System.out.println("Event ID:" + id);
		return id;
	}

	public static String getName(Scanner sc) {
		System.out.print("Enter name: ");
		String name = validOutput.getString(sc);
		return name;
	}

	public static int numberOfAttendence(Scanner sc) {
		int Attended = 0; // Initialize to an invalid number to ensure it gets updated

		System.out.print("Enter number of attendance: ");
		try {
			Attended = Integer.parseInt(validOutput.getString(sc)); // Try to parse the input
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			e.printStackTrace();
			sc.next();
		}
		return Attended;
	}

	public static String getLocation(Scanner sc) {
		System.out.print("Enter location: ");
		String name = validOutput.getString(sc);
		return name;
	}

	// Check input status yes or no
	public static boolean inputStatus(Scanner sc) {
		String inputStatus;

		while (true) {
			System.out.print("Is this event active (y/n):");
			inputStatus = validOutput.getString(sc);

			if (inputStatus.equals("y") || inputStatus.equals("yes")) {
				System.out.print("You entered: " + inputStatus);
				return true; // Event is active
			} else if (inputStatus.equals("n") || inputStatus.equals("no")) {
				System.out.print("You entered: " + inputStatus);
				
				return false; // Event is not active
			} else {
				System.out.print("Invalid input. Please enter 'y', 'yes', 'n', or 'no'.");
				
			}
		}
	}
}	
	