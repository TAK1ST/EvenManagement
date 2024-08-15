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
            Menu.displayMainMenu(); // Display menu options
            choice = getEventOption();
            // Process the choice
            switch (choice) {
                case 1:
                    validOutput.clearScreen();
                    Service.createEvent();
                    break;
                case 2:
                    // check Exit
                    System.out.println("check Exits" + "");
                    break;
                case 3:
                    validOutput.clearScreen();
                    //search Ìnformation event
                    System.out.println("Search for event information by location.");
                    break;
                case 4:
                    validOutput.clearScreen();
                    //Update event
                    System.out.println("Update event.");
                    break;
                case 5:
                    //save file
                    saveToFile();
                    break;
                case 6:
                    validOutput.clearScreen();
                    // show list Events
                    Menu.printListEvent();

                    break;
                case 7:
                    validOutput.clearScreen();
                    System.out.println("Goodbye");
                    return;
                default:
                    validOutput.clearScreen();
                    System.out.println("Invalid choice. Please enter a number in the Menu.");
                    break;
            }
        } while (choice != 7);
    }
}
