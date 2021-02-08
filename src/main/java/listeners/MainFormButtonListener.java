package listeners;

import project1.io.SaveData;
import ui.FileDBChooserPanel;
import ui.ReadFilePanel;
import ui.SomeReadEditUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import static ui.MainForm.*;

public class MainFormButtonListener implements ActionListener {
    JButton readB;
    JButton updateB;
    JButton createB;
    JButton removeB;
    JButton exitB;
    public static int returnVal;
    public static FileDBChooserPanel fileDBChooserPanel;

    public MainFormButtonListener(JButton readB, JButton updateB, JButton createB, JButton removeB, JButton exitB) {
        this.readB = readB;
        this.updateB = updateB;
        this.createB = createB;
        this.removeB = removeB;
        this.exitB = exitB;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == readB) {
            fileDBChooserPanel = new FileDBChooserPanel();
        }
    }
}
