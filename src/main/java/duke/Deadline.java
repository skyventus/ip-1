package main.java.duke;

import java.text.SimpleDateFormat;

public class Deadline extends Todo{
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }

    @Override
    public String saveTask(){
        return "D | " + (super.isDone() ? "1" : "0") + " | " + super.getDescription() + " | " + deadline + "\n";
    }

}
