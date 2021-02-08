package project1.io;

import listeners.ReadFilePanelBL;
import ui.ReadFilePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import static ui.ReadFilePanel.newline;
import static listeners.MainFormButtonListener.returnVal;

public class SaveData {
    JTextArea log;
    JFileChooser fc;
    public static File file;

    public SaveData(JTextArea log, JFileChooser fc) {
        this.log = log;
        this.fc = fc;
    }

    //   private static void createAndShowGUI() {
 //       //Create and set up the window.
 //       frame = new JFrame("FileChooserDemo");
 //       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
 //       //Add content to the window.
 //       frame.add(new ReadFilePanelBL());
//
 //       //Display the window.
 //       frame.pack();
 //       frame.setVisible(true);
 //   }

    public void openFile() {
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            log.append("Opening: " + file.getName() + "." + newline);
        } else {
            log.append("Open command cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());
    }
}
