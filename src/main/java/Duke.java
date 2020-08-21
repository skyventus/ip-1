import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String command;
        Scanner in = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
////        System.out.println("Hello from\n" + logo);
        String line = "----------------------------------------";
        String helloMessage = "Hello! I'm Duke";
        String greetMsg = "What can I do for you?";
        String byeMsg = "Bye. Hope to see you again";

        System.out.println(line);
        System.out.println(helloMessage);
        System.out.println(greetMsg);
        System.out.println(line);

        System.out.println(line);
        System.out.println(byeMsg);
        System.out.println(line);


    }
}
