package utils;

import Duke.Deadline;
import Duke.Event;
import Duke.Task;

public class Parser {

    public static String getCommandWord(String fullCommand){
        String[] task;

        fullCommand=fullCommand.toLowerCase().trim();

        task = fullCommand.split(" ");
        try {
            if(task[0].equals("todo"))
                return "todo";
        }catch(ArrayIndexOutOfBoundsException e){
            Ui.printError(e.getMessage());
        }
        return task[0];
    }

    public static Task createTodo(String fullCommand){
        Task todoTask = new Task(fullCommand.trim());
        return todoTask;
    }

    public static Event createEvent(String fullCommand, String at){
        Event event = new Event(fullCommand.trim(),at);
        return event;
    }
    public static Deadline createDeadline(String fullCommand, String by){
        Deadline deadline = new Deadline(fullCommand, by);
        return deadline;
    }

    public static String getObjectType(Task task){
        if(task instanceof Deadline)
            return "D";
        else if (task instanceof Event)
            return "E";
        else
            return "T";
    }

}