package listeners;

import project1.io.FileHelper;
import ui.Table;

import javax.swing.*;
import java.lang.reflect.Executable;
import java.util.ArrayList;

public class Container {
    private final Table table;
    private String fileName = "";
    private FileHelper fileExecutor;
    private ArrayList personList;

    public Container(JFrame jFrame) {
        table = new Table(jFrame, this);
    }

    public Table getTable() {
        return table;
    }

    public FileHelper getFileExecutor() {
        return fileExecutor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExecutor(FileHelper fileExecutor) {
        this.fileExecutor = fileExecutor;
    }

    public void setPersonList(ArrayList personList){
        this.personList = personList;
    }

    public ArrayList getPersonList(){
        return personList;
    }
}