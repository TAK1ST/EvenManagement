package eventmanagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtil {
    public static LocalDate inputEventDate(Scanner sc) {
        LocalDate eventDate = null;
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy M d");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM dd, yyyy");
        
        while (eventDate == null) {
            System.out.print("Enter a date (yyyy MM dd): ");
            String inputDate = validOutput.getString(sc);
            
            try {
                // Parse the input date to LocalDate
                eventDate = LocalDate.parse(inputDate, inputFormatter);
                
                // Format the LocalDate to the desired output format
                String formattedDate = eventDate.format(outputFormatter);
                
                // Print the formatted date
                System.out.println("Formatted date: " + formattedDate);
                
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use the format yyyy M d.");
            }
        }
        
        return eventDate;
}
}