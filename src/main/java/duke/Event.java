package main.java.duke;

/**
 * Event is a class that extends Todo
 * As Event consist of event information in this class.
 * @author olivier cheah
 */

public class Event extends Todo {
    private String eventInformation;

    public Event(String description, String event){
        super(description);
        this.eventInformation = event;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + eventInformation + ")";
    }

}
