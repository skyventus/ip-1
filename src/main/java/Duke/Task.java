package Duke;

public abstract class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

}