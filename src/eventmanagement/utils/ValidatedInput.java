package eventmanagement.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidatedInput {
	public static LocalDate inputEventDate() {
		LocalDate eventDate = null;
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy M d");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM d, yyyy");
		System.out.println("Enter a date (yyyy MM dd)");
		String inputDate = sc.nextLine();
		try {
			// parse the input date to LocalDate
			eventDate = LocalDate.parse(inputDate, inputFormatter);
			// Format the LocalDate to the desired output format
			String formattedDate = eventDate.format(outputFormatter);

			// Print the formatted date
			System.out.println("Formatted date: " + formattedDate);
		} catch (DateTimeException e) {
			System.out.println("Invalid date format. Please use the format yyyy MM dd.");
			e.printStackTrace();
		}
		sc.close();
		return eventDate;
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
			} 
            else if (inputStatus.equals("n") || inputStatus.equals("no")) {
                System.out.println("You entered: " + inputStatus);
                sc.close();
				return false; // Event is not active
            }
            else {
                System.out.println("Invalid input. Please enter 'y', 'yes', 'n', or 'no'.");
				sc.close();
			}
        }	
	}
}