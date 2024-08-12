package eventmanagement;

import java.util.Scanner;

import eventmanagement.service.Service;
import eventmanagement.utils.validOutput;

public class EventManagerment {
	public static String FILE_NAME = "./src/data/EventsData.txt";
	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		
		do {
			Menu.displayMainMenu(); // Display menu options
			System.out.print("Your select: ");
			choice = Integer.parseInt(validOutput.getString(sc)); // Get user choice
			// Process the choice
			switch (choice) {
			case 1:
				Service.createEvent();
				break;
			case 2:
				// Add logic for case 2
				System.out.println("Case 2 selected.");
				break;
			case 3:
				// Add logic for case 3
				System.out.println("Case 3 selected.");
				break;
			case 4:
				// Add logic for case 4
				System.out.println("Case 4 selected.");
				break;
			case 5:
				// Add logic for case 5
				System.out.println("Case 5 selected.");
				break;
			case 6:
				// Add logic for case 6
				System.out.println("Case 6 selected.");
				break;
			case 7:
				System.out.println("Goodbye");
				return;
			default:
				System.out.println("Invalid choice. Please enter a number in the Menu.");
				break;
			}
		} while (choice != 7); // Continue until user selects '7' to exit
	}
}