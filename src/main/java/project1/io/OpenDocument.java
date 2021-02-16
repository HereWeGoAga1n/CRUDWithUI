package project1.io;

import org.json.simple.parser.ParseException;
import project1.FormatFactory;
import project1.cmd.Executable;
import project1.model.Person;

import static ui.MainMenu.container;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ui.ReadFilePanel.newline;

public class OpenDocument {
    JFileChooser fc;
    public static File file;
    public static String fileName;

    public OpenDocument(JFileChooser fc) {
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
        file = fc.getSelectedFile();
        fileName = file.getName();
        container.setFileName(fileName);
        String format = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        FormatFactory formatFactory = new FormatFactory();
        Executable executable = formatFactory.getInstance(format);
        List<Person> persons = new ArrayList<>();
        persons = executable.read();
        container.getTable().redrawTable();
    }
}
