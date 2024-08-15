package eventmanagement;

import static eventmanagement.Menu.getEventOption;
import static eventmanagement.Menu.loadEventFromFile;
import static eventmanagement.Menu.saveToFile;
import eventmanagement.service.Service;
import eventmanagement.utils.validOutput;

public class EventManagement {
        public static void main(String[] args) {
        int choice;
        loadEventFromFile();
        do {
            validOutput.clearScreen();
            Menu.displayMainMenu(); // Display menu options
            choice = getEventOption();
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
                    //save file
                    saveToFile();
                    break;
                case 6:
                    // show list Events
                    loadEventFromFile();
                    
                    break;
                case 7:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number in the Menu.");
                    break;
            }
        } while (choice != 7);	
    }
}
