package eventmanagement.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events implements Serializable {

    protected static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected LocalDate eventDate;
    protected String location;
    protected int number_of_attendees;
    protected String status;

    public Events(int id, String name, LocalDate eventDate, String location, int number_of_attendees, String status) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.location = location;
        this.number_of_attendees = number_of_attendees;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEventDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return getEventDate().format(formatter);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
