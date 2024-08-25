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
                    validOutput.clearScreen();
                    Service.checkEventExist();
                    break;
                case 3:
                    validOutput.clearScreen();
                    //search Ìnformation event
                    Service.searchEvent();
                    break;
                case 4:
                    validOutput.clearScreen();
                    //Update event
                    Service.updateEvent();
                    
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
