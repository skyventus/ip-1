import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String command;
        Scanner in = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String line = "----------------------------------------";
        String helloMessage = "Hello! I'm Duke";
        String greetMsg = "What can I do for you?";
        String byeMsg = "Bye. Hope to see you again";
        String indent = "    ";
        System.out.println(indent + line);
        System.out.println(indent + helloMessage);
        System.out.println(indent + greetMsg);
        System.out.println(indent + line);

        command = in.nextLine();

        while(! command.toLowerCase().contains("bye")){
            if(command.toLowerCase().equals("list")) {
                int i = 0;
                for(String task: tasks) {
                    System.out.println("[" + (i + 1) + "] " + task);
                    i++;
                }
            }else {
                System.out.println(indent + line);
                tasks.add(command);
                System.out.println(indent + "added: " + command);
                System.out.println(indent + line);
            }
            command = in.nextLine().toLowerCase();
        }

        System.out.println(indent + line);
        System.out.println(indent + byeMsg + "\n");
        System.out.println(indent + line);

    }
}
