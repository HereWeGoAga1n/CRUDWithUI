package listeners;

import org.json.simple.parser.ParseException;
import project1.io.OpenDocument;
import ui.ChooseDBPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FileDBChooserButtonListener implements ActionListener {

    JButton fileB;
    JButton dbB;
    public static int returnVal;
    ChooseDBPanel chooseDBPanel;
    OpenDocument saveData;
    public FileDBChooserButtonListener(JButton fileB, JButton dbB) {
        this.fileB = fileB;
        this.dbB = dbB;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == fileB){
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary, JSON, CSV, XML, YAML", "json", "csv", "xml", "yaml", "bin");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(filter);
            returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                saveData = new OpenDocument(fileChooser);
                try {
                    saveData.openFile();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        } else if (source == dbB){
            chooseDBPanel = new ChooseDBPanel();
            chooseDBPanel.changeToDBPanel();
        }
    }
}
