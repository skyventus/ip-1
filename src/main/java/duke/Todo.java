package main.java.duke;

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
    public String saveTask(){
        return "T | " + (taskStatus ? "1" : "0")+ " | " + super.getDescription() + "\n";
    }


    @Override
    public void setDone(boolean done) {
        this.taskStatus=done;
    }
}
