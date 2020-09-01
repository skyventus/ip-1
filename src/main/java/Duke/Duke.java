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

        String fullCommand = ui.readUserCommand().toLowerCase();
        String commandWord = Parser.getCommandWord(fullCommand);

        while(!commandWord.equals("bye")) {
            try{
                switch(commandWord){
                    case("list"):
                        task.printTasks();
                        break;
                    case("done"):
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
                        Ui.showToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        break;
                }
            }catch (DukeException e){
                System.out.println(e.getMessage());
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
