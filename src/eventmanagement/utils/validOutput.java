package eventmanagement.utils;

import java.util.Scanner;

public class validOutput {
	public static String getString(Scanner sc) {
		String input = sc.nextLine().trim().toLowerCase();
		return input;
	}
	
}