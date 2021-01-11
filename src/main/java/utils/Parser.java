package main.java.utils;

import main.java.duke.Deadline;
import main.java.duke.DukeException;
import main.java.duke.Event;
import main.java.duke.Task;
import main.java.duke.Todo;

/**
 * Parser is a class that help to parser needed information into program friendly terms
 * @author olivier cheah
 */
public class Parser {

    public static String getCommandWord(String fullCommand) {
        String[] task;

        fullCommand = fullCommand.toLowerCase().trim();

        task = fullCommand.split(" ");
        try {
            if (task[0].equals("todo"))
                return "todo";
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printError(e.getMessage());
        }
        return task[0];
    }

    public static Todo createTodo(String fullCommand) {

        Todo task = new Todo(fullCommand.trim());

        return task;
    }

    public static Event createEvent(String fullCommand, String at) {
        Event event = new Event(fullCommand.trim(), at);

        return event;
    }

    public static Deadline createDeadline(String fullCommand, String by) {
        Deadline deadline = new Deadline(fullCommand, by);

        return deadline;
    }

    public static String getDescriptionOnly(String fullCommand, String commandWord, String additionalInfo) throws DukeException {
        try {
            String description = fullCommand.substring(0, fullCommand.indexOf(additionalInfo))
                    .replace(commandWord, "").trim();
            if (description.isEmpty())
                throw new DukeException("[ERROR] no description found.");
            return description;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("[ERROR] Missing /at or /by in the command.");
        }
    }

    public static String getTodoDescription(String fullCommand, String commandWord) throws DukeException {

        String description = fullCommand.replace(commandWord, "").trim();
        if (description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        return description;
    }

    public static String getDeadline(String fullCommand) throws DukeException {

        try {
            String deadline = fullCommand.substring(fullCommand.indexOf("/by"))
                    .replace("/by", "").trim();
            if (deadline.isEmpty())
                throw new DukeException("[ERROR] no description found.");
            return deadline;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("[ERROR] Missing /by in the command.");
        }
    }

    public static String getEventTiming(String fullCommand) throws DukeException {

        try {
            String eventTiming = fullCommand.substring(fullCommand.indexOf("/at"))
                    .replace("/at", "").trim();

            return eventTiming;
        } catch (Exception e) {
            throw new DukeException("[ERROR] Missing /at in the command.");
        }
    }

    public static int getTaskIndex(String fullCommand) {
        int idx = Integer.parseInt(fullCommand.replace("done", "")
                .trim());

        return idx;
    }

    public static int getDeleteIndex(String fullCommand) {
        int idx = Integer.parseInt(fullCommand.replace("delete", "")
                .trim());

        return idx;
    }
    public static String getTaskType(Task task) {
        if (task instanceof Deadline)
            return "D";
        else if (task instanceof Event)
            return "E";
        else
            return "T";
    }

    public static String getItemToFind(String fullCommand, String commandWord) throws DukeException {

        String getItemToFind = fullCommand.replace(commandWord, "").trim();
        if (getItemToFind.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        return getItemToFind;
    }

    public static boolean findMatchKeywords(String description, String keyword){
        String[] splitDescription;
        splitDescription = description.split(" ");

        for (String word: splitDescription) {
            if(word.equalsIgnoreCase(keyword))
                return true;
        }
        return false;
    }
}