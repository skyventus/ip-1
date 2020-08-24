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
        String command = Parser.getCommandWord(fullCommand);

        while(!command.equals("bye")) {
            switch(command){
                case("list"):
                    task.printTasks();
                    break;
                case("done"):
                    idx = Integer.parseInt(fullCommand.replace("done", "")
                            .trim());
                    Ui.printDone();
                    task.completedTask(idx);
                    break;
                case("todo"):
                    Description=fullCommand.replace(command, "");
                    task.addTask(Parser.createTodo(Description));
                    break;
                case("deadline"):
                    String by = fullCommand.substring(fullCommand.indexOf("/by"))
                            .replace("/by", "").trim();
                    Description=fullCommand.substring(0, fullCommand.indexOf("/by"))
                            .replace(command, "").trim();
                    task.addTask(Parser.createDeadline(Description,by));
                    break;
                case("event"):
                    String at = fullCommand.substring(fullCommand.indexOf("/at"))
                            .replace("/at", "").trim();
                    Description=fullCommand.substring(0, fullCommand.indexOf("/at"))
                            .replace(command, "").trim();
                    task.addTask(Parser.createEvent(Description,at));
                    break;
                default:
                    Ui.showToUser("[WARNING] No such command exist.");
                    break;
            }
            fullCommand = ui.readUserCommand().toLowerCase();
            command = Parser.getCommandWord(fullCommand);
        } ui.showByeMessage();

    }
    public static void main(String[] args) {
        new Duke().run();
    }
}
