package ui.ButtonListeners;

import fileHelpers.FileExecutor;
import ui.Table;

import javax.swing.*;
import java.lang.reflect.Executable;
import java.util.ArrayList;

public class Container {
    private final Table table;
    private String fileName = "";
    private FileExecutor fileExecutor;
    private ArrayList personList;

    public Container(JFrame jFrame) {
        table = new Table(jFrame, this);
    }

    public Table getTable() {
        return table;
    }

    public FileExecutor getFileExecutor() {
        return fileExecutor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExecutor(FileExecutor fileExecutor) {
        this.fileExecutor = fileExecutor;
    }

    public void setPersonList(ArrayList personList){
        this.personList = personList;
    }

    public ArrayList getPersonList(){
        return personList;
    }
}
