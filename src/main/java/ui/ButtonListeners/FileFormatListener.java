package ui.ButtonListeners;

import ui.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileFormatListener implements ActionListener {
    private JTextField fileName;
    private ActionListener fileFormat;
    private Container container;

    public FileFormatListener(ActionListener comboBoxListener){
        fileFormat = comboBoxListener;
    }

    public FileFormatListener(Container container, JTextField fileName){
        this.fileName = fileName;
        this.container = container;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = this.fileName.getText();
        JComboBox comboBox = (JComboBox)e.getSource();
        String fileType = (String)comboBox.getSelectedItem();
        container.setFileName(fileName);
        MainMenu mm = new MainMenu();

//        container.setFileExecutor(fileType);

    }
}
