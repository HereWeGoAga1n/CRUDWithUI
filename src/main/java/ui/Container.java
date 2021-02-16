package ui;

import project2.io.FileHelper;

import javax.swing.*;

public class Container {
    public static Table table = null;
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
