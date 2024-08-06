package Menu;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("------------Welcome come to Envent Management--------------");
            System.out.println("1. Create a new event\n2. Check if an event exists\n3. Search for event information by location"
                    + "4. Update event\n5. Save events to a file\n6. Print the list of events from the file\n7. Quit");
            System.out.print(">>Your choice: ");
            int choice = Integer.parseInt(sc.next());
            clearScreen();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("GoodBye");
                    return;
                default:
                    System.out.println("!!!Invalid Choice, do it aigain!!!");
            }
        } while (true);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
