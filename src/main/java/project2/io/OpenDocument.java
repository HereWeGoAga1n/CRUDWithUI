package project2.io;

import org.json.simple.parser.ParseException;
import project2.FormatFactory;
import project2.cmd.Executable;
import project2.model.Person;

import static ui.MainMenu.container;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OpenDocument {
    JFileChooser fc;
    public static File file;
    public static String fileName;
    public static Executable executable;

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
        executable = formatFactory.getInstance(format);
        List<Person> persons = new ArrayList<>();
        persons = executable.read();
        container.getTable().redrawTable();
    }
}
