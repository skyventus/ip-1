package main.java.duke;

/**
 * Todo is a class that extends to task. As it contains the status of the tasks.
 * @author Olivier Cheah
 */
public class Todo extends Task {
    boolean taskStatus;

    public Todo(String Desc){
        super(Desc);
        taskStatus=false;
    }
    @Override
    public boolean isDone() {
        return taskStatus;
    }

    @Override
    public void setDone(boolean done) {
        this.taskStatus=done;
    }
}
