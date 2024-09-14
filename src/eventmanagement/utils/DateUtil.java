package eventmanagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtil {

    public static LocalDate inputEventDate(Scanner sc) {
        LocalDate eventDate = null;

        // Define multiple date formats
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
            DateTimeFormatter.ofPattern("yyyy M d"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("yyyy/M/d")
        };

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM dd, yyyy");

        while (eventDate == null) {
            System.out.print("Enter a date (yyyy M d, yyyy-M-d, yyyy/M/d): ");
            String inputDate = sc.nextLine();

            // Try each format until parsing succeeds
            for (DateTimeFormatter formatter : formatters) {
                try {
                    // Parse the input date to LocalDate
                    eventDate = LocalDate.parse(inputDate, formatter);

                    // Format the LocalDate to the desired output format
                    String formattedDate = eventDate.format(outputFormatter);

                    // Print the formatted date
                    System.out.println("Formatted date: " + formattedDate);
                    break;

                } catch (DateTimeParseException e) {
                    // Continue trying other formats
                }
            }

            if (eventDate == null) {
                System.out.println("Invalid date format. Please use one of the formats: yyyy M d, yyyy-M-d, yyyy/M/d.");
            }
        }

        return eventDate;
    }
}
