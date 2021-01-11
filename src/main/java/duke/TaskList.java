package main.java.duke;

import main.java.utils.Parser;
import main.java.utils.Ui;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskList is a class that hold a list of tasks and its related function.
 * @author Olivier Cheah
 */
public class TaskList {
    private List<Task> tasks;
    Ui ui = new Ui();

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        ui.printGotIt();
        ui.showAddedTask(Parser.getTaskType(task), task.toString());
        ui.showTotalNumberTaskAdded(tasks.size());
    }

    public void addTaskWithoutMessage(Task task) {
        tasks.add(task);
    }
    public void printTasks() {
        //to keep track of item starting from 1
        int itemRank = 1;

        if (tasks.isEmpty())
            ui.showToUser("No tasks has been added to the list yet.");

        for (Task task : tasks) {
            ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
            itemRank++;
        }
    }

    public void setTaskDone(int idx) throws DukeException {
        try {
            ui.printDone();
            tasks.get(idx - 1).setDone(true);
            ui.showDoneTask(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("[ERROR] No task found for the number you want to set done");
        }
    }

    public boolean isTaskCompleted(int idx){
        return tasks.get(idx - 1).isDone();
    }

    public void setTaskDoneSliently(int idx) throws DukeException {
        try {
            ui.printDone();
            tasks.get(idx - 1).setDone(true);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("[ERROR] No task found for the number you want to set done");
        }
    }
    public void removeTask(int idx) throws DukeException{
        try{
            ui.showDeleteMessage();
            ui.showDeleteTaskDetails(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString(), tasks.get(idx - 1).isDone());
            tasks.remove(idx - 1);
            ui.showTotalNumberTaskAdded(tasks.size());
        }catch (IndexOutOfBoundsException e){
            throw new DukeException("[ERROR] No task found for the number you want to set done");
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = tasks.isEmpty();
        return isEmpty;
    }

    public int getSize(){
        return tasks.size();
    }

    public String saveTask(int idx){
        String value = tasks.get(idx).saveTask();
        //System.out.println(value);
        return value;
    }

    public void findTask(String keyword){
        int itemRank = 1;

        if (tasks.isEmpty())
            ui.showToUser("No tasks has been added to the list yet.");

        for (Task task : tasks) {
            if(Parser.findMatchKeywords(task.getDescription().trim(), keyword)) {
                ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
                itemRank++;
            }
        }
        if(itemRank == 1){
            ui.showToUser("No item matched in the list.");
        }
    }
}
