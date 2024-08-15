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
}