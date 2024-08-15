package eventmanagement.utils;

import java.util.Scanner;

public class validOutput {

    public static String getString(Scanner sc) {
        String input = sc.nextLine().trim().toLowerCase();
        return input;
    }

    public static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }

    public static String padSpaces(String value, int length) {
        int spacesToAdd = length - value.length();
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < spacesToAdd; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
