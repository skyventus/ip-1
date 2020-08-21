import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        //tasks.add(task);
        tasks.add(task);
        //System.out.println("Tasks in the list: " + tasks.size());
    }

    public void printTasks() {
        String checkedMark = "\u2713";
        String cross = "\u2715";

        if(tasks.isEmpty())
            System.out.println("No tasks has been added to the list yet.");
        int i=0;
        for(Task task: tasks) {
            if(task.isDone())
                System.out.println((i + 1) + ". [" + checkedMark  + "] " + task.getDescription());
            else
                System.out.println((i + 1) + ". [" + cross  + "] " + task.getDescription());
            i++;
        }
    }

    public void printOneTask(int idx) {
        String checkedMark = "\u2713";
        String indent = "    ";
        System.out.println(indent + " [" + checkedMark  + "] " +      tasks.get(idx-1).getDescription());
    }
    public void completedTask(int idx){
        tasks.get(idx-1).setDone(true);
    }

    public int getSize(){
        return tasks.size();
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    public void deleteTask(int idx){
        tasks.remove(tasks.get(idx-1));
        System.out.println("Task has been deleted.");
    }
}
