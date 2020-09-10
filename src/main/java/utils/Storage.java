package main.java.utils;
import main.java.duke.DukeException;
import main.java.duke.TaskList;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Storage {

    private String filePath;
    private String filename;
    private Ui myUI = new Ui();

    public Storage(String filePath, String filename){
        this.filePath = filePath;
        this.filename = filename;
        File directory = new File(filePath);
        if(! directory.exists()) {
            directory.mkdir();
            System.out.println(directory.exists());
        }
    }

    public void save(TaskList tasks) throws DukeException {
        FileWriter fw ;
        if(tasks.isEmpty()){
            System.out.println("[INFO] No tasks in the file to save");
        }else {
            try {
                fw = new FileWriter(filePath+"/"+filename);
                for (int i = 0; i < tasks.getSize(); i++) {
                    fw.write(tasks.saveTask(i));
                }
                fw.close();
                myUI.showFileSavedMessage();
            } catch (IOException e) {
                throw new DukeException(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException(e.getMessage());
            }
        }

    }

}
