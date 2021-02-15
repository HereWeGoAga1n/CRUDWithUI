package project1.io;

import listeners.ReadFilePanelBL;
import org.json.simple.parser.ParseException;
import project1.FormatFactory;
import project1.cmd.Executable;
import project1.model.Person;
import ui.ReadFilePanel;
import static ui.MainMenu.container;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ui.ReadFilePanel.newline;
import static listeners.MainFormButtonListener.returnVal;

public class OpenDocument {
    JTextArea log;
    JFileChooser fc;
    public static File file;
    public static String fileName;

    public OpenDocument(JTextArea log, JFileChooser fc) {
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

    public void openFile() throws ParseException, IOException, ClassNotFoundException {
        System.out.println("open file is working");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            fileName = file.getName();
            container.setFileName(fileName);
            String format = fileName.substring(fileName.lastIndexOf("."),fileName.length());
            FormatFactory formatFactory = new FormatFactory();
            Executable executable = formatFactory.getInstance(format);
            List<Person> persons = new ArrayList<>();
            persons = executable.read();
            container.getTable().redrawTable();
            //This is where a real application would open the file.
            log.append("Opening: " + file.getName() + "." + newline);
        } else {
            log.append("Open command cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());
    }
}
