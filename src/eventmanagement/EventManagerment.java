package eventmanagement;

import java.util.Scanner;

public class EventManagerment {
	public static String FILE_NAME = "./src/data/EventsData.txt";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// need fix choice with Menu.getEventOption
		int choice;
		Menu.getEventOption(sc);
		do {
			Menu.displayMainMenu();
			
			
		} while (true);
	}
}