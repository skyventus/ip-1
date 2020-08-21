public class Task {
    private String description;
    private boolean isDone;

    public Task(String desc){
        this.description=desc;
        this.isDone=false;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isDone(){
        return this.isDone;
    }

    public String getDescription(){
        return this.description;
    }
    @Override
    public String toString() {
        return  description;
    }
}