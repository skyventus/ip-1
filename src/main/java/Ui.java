import java.util.Scanner;


public class Ui {

    private Scanner in;
    static String indent = "    ";
    public Ui() {
        in = new Scanner(System.in);
    }

    public static void printWelcome(){
        System.out.println(indent+"Hello! I'm Duke");
        System.out.println(indent+"What can I do for you?");
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printAdded(String command){
        System.out.println(indent+ "Added: " + command);
    }

    public static void printDone() {
        System.out.println(indent + " Nice! I've marked this task as done: ");
    }

    public String readUserCommand() {
        System.out.print("Your task? \n");
        return in.nextLine().trim();
    }

    public void printBye() {
        System.out.println(indent+ "Bye. Hope to see you again");
    }
}
