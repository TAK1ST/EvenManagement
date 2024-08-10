package eventmanagement.utils;

import java.util.Random;
import java.util.Scanner;

public class ValidatedInput {
	// check get ID
	public static int getID() {
		int id;
		Random random = new Random();
		id = random.nextInt(100000);
		return id;
	}
//fix bug
	public static int numberOfAttendence(Scanner sc) {
		int Attended = -1;
		while (true) {
			String input = String.valueOf(sc);
			if (isValidInteger(input)) {
				Attended = Integer.parseInt(input);
				break;
			} else {
				System.out.println("Invalid input. Please enter a valid integer.");
				System.out.print("Enter the number of attendees: ");
				sc.next();
			}
		}
		return Attended;
	}

	// check input is the Integer
	public static boolean isValidInteger(String str) {
		try {
			Integer.parseInt(str); // Attempt to parse the string to an Integer
			return true; // If successful, the input is a valid integer
		} catch (NumberFormatException e) {
			return false; // If parsing fails, the input is not a valid integer
		}
	}

	// Check input status yes or no
	public static boolean inputStatus() {
		Scanner sc = new Scanner(System.in);
		String inputStatus;

		while (true) {
			System.out.println("Is this event active (y/n):");
			inputStatus = sc.nextLine().trim().toLowerCase();

			if (inputStatus.equals("y") || inputStatus.equals("yes")) {
				System.out.println("You entered: " + inputStatus);
				sc.close();
				return true; // Event is active
			} else if (inputStatus.equals("n") || inputStatus.equals("no")) {
				System.out.println("You entered: " + inputStatus);
				sc.close();
				return false; // Event is not active
			} else {
				System.out.println("Invalid input. Please enter 'y', 'yes', 'n', or 'no'.");
				sc.close();
			}
		}
	}
}