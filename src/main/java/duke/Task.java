package main.java.duke;

public abstract class Task {
    private String description;
//    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }

    //Abstract methods
    public abstract boolean isDone();

    public abstract void setDone(boolean done);

}