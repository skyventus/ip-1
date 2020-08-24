package utils;

import Duke.Task;

import java.util.Scanner;


public class Ui {

    private Scanner in;
    static String indent = "    ";
    public Ui() {
        in = new Scanner(System.in);
    }
    String checkedMark = "\u2713";
    String cross = "\u2715";


    public static void printWelcome(){
        System.out.println(indent+"Hello! I'm Duke.Duke");
        System.out.println(indent+"What can I do for you?");
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printDone() {
        System.out.println(indent + " Nice! I've marked this task as done: ");
    }

    public static void showToUser(String s) {
        System.out.println(s);
    }

    public static void printGotIt(){
        System.out.println(indent + "Got it. I've added this task:");
    }

    public String readUserCommand() {
        System.out.print("Your task? \n");
        return in.nextLine().trim();
    }

    public void showAddedTask(String classType, String description){
        System.out.println(indent + "  ["+classType+"][" + cross  + "] " +  description);
    }

    public void showDoneTask(String classType, String description){
        System.out.println(indent + "  ["+classType+"][" + checkedMark  + "] " +  description);
    }
    public void showTaskWithOrder(String classType, String description, int rank, boolean isDone){
        System.out.println(indent + rank + ".["+classType+"][" + (isDone ? checkedMark : cross)  + "] " +  description);
    }

    public void showTotalNumberTaskAdded(int totalNumberOfTask){
        System.out.println(indent + "Now you have " + totalNumberOfTask + " tasks in the list");
    }

    public void showByeMessage() {
        System.out.println(indent+ "Bye. Hope to see you again");
    }
}
