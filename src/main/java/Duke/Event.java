package Duke;

public class Event extends Task {
    private String eventInformation;

    public Event(String desc, String event){
        super(desc);
        this.eventInformation = event;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + eventInformation + ")";
    }

}
