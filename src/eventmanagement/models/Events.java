package eventmanagement.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Events implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected LocalDate eventDate;
    protected String location;
    protected int number_of_attendees;
    protected boolean status;
    protected String description;
    	
    public Events(int id,String name, LocalDate eventDate, String location, int number_of_attendees, boolean status)
    {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.location= location;
        this.number_of_attendees = number_of_attendees;
        this.status= status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber_of_attendees() {
        return number_of_attendees;
    }

    public void setNumber_of_attendees(int number_of_attendees) {
        this.number_of_attendees = number_of_attendees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void showEvent() {
        System.out.print("| Name : " + name + " ".repeat(25 - String.valueOf(name).length()) + "|");
        System.out.print(" id : " + id + " ".repeat(25 - String.valueOf(id).length()) + "|");
        System.out.print(" evenDate : " + eventDate + " ".repeat(25 - 7)  + "|"); 
        System.out.print(" Location : " + location + " ".repeat(25 - String.valueOf(location).length()) + "|");
        System.out.print(" status : " + status + " ".repeat(25 - String.valueOf(status).length()) + "|");

        // Xử lý mô tả nếu vượt quá kích thước cột
        if (name.length() > 25) {
            String truncatedName= name.substring(0, 22) + "...";
            System.out.println(
                    "Name : " + truncatedName + " ".repeat(25 - truncatedName.length()) + "|");
        } else {
            System.out.println("Name : " + description + " ".repeat(25 - description.length()) + "|");
        }
    }
}
