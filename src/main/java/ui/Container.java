package ui;

import project1.io.FileHelper;
import project1.io.FileHelper;
import ui.Table;

import javax.swing.*;
import java.lang.reflect.Executable;

public class Container {
    private final Table table;
    private String fileName = "";
    private FileHelper fileExecutor;

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
}
