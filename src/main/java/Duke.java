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
        String command;
        if(fullCommand.contains("done"))
            command="done";
        else
            command=fullCommand;
        while(!command.equals("bye")) {
            switch(command){
                case("list"):
                    task.printTasks();
                    break;
                case("done"):
                    idx = Integer.parseInt(fullCommand.replace("done", "").trim());
                    Ui.printDone();
                    task.completedTask(idx);
                    task.printOneTask(idx);
                    break;
                default:
                    if(!fullCommand.equals("")) {
                        task.addTask(new Task(fullCommand));
                        Ui.printAdded(fullCommand);
                    }else{
                        Ui.printError("Please key in your task...");
                    }
                    break;
            }
            fullCommand = ui.readUserCommand().toLowerCase();
            if(fullCommand.contains("done"))
                command="done";
            else
                command=fullCommand;
        } ui.printBye();

    }
    public static void main(String[] args) {
        new Duke().run();
    }
}
