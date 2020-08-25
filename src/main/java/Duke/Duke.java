package Duke;

import utils.Ui;
import utils.Parser;

public class Duke {

    private Ui ui;
    private TaskList task;

    public void run(){
        ui = new Ui();
        task = new TaskList();
        ui.printWelcome();

        String Description;
        int idx;
        String fullCommand = ui.readUserCommand().toLowerCase();
        String commandWord = Parser.getCommandWord(fullCommand);

        while(!commandWord.equals("bye")) {
            switch(commandWord){
                case("list"):
                    task.printTasks();
                    break;
                case("done"):
                    Ui.printDone();
                    task.setTaskDone(Parser.getTaskIndex(fullCommand));
                    break;
                case("todo"):
                    task.addTask(Parser.createTask(Parser.getTodoDescription(fullCommand,commandWord)));
                    break;
                case("deadline"):
                    task.addTask(Parser.createDeadline(Parser.getDescriptionOnly(fullCommand,commandWord, "/by")
                            ,Parser.getDeadline(fullCommand)));
                    break;
                case("event"):
                    task.addTask(Parser.createEvent(Parser.getDescriptionOnly(fullCommand,commandWord, "/at")
                            ,Parser.getEventTiming(fullCommand)));
                    break;
                default:
                    Ui.showToUser("[WARNING] No such command exist.");
                    break;
            }
            fullCommand = ui.readUserCommand().toLowerCase();
            commandWord = Parser.getCommandWord(fullCommand);
        }

        ui.showByeMessage();

    }
    public static void main(String[] args) {
        new Duke().run();
    }
}
