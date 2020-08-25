package Duke;

import utils.Parser;
import utils.Ui;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    Ui ui = new Ui();

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
        ui.printGotIt();
        ui.showAddedTask(Parser.getTaskType(task), task.getDescription());
        ui.showTotalNumberTaskAdded(tasks.size());
    }

    public void printTasks() {

        if(tasks.isEmpty())
            Ui.showToUser("No tasks has been added to the list yet.");
        int rank=1;
        for(Task task: tasks) {
            ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(),rank, task.isDone());
            rank++;
        }
    }

    public void setTaskDone(int idx){
        tasks.get(idx-1).setDone(true);
        ui.showDoneTask(Parser.getTaskType(tasks.get(idx-1)), tasks.get(idx-1).toString());
    }
}
