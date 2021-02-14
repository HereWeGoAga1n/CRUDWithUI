package listeners;

import ui.ChooseDBPanel;
import ui.ReadFilePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static listeners.MainFormButtonListener.fileDBChooserPanel;

public class FileDBChooserButtonListener implements ActionListener {

    JButton fileB;
    JButton dbB;
    public static int returnVal;
    ChooseDBPanel chooseDBPanel;
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
            returnVal = fileChooser.showOpenDialog(new ReadFilePanel());
        } else if (source == dbB){
            chooseDBPanel = new ChooseDBPanel();
            chooseDBPanel.changeToDBPanel();
        }
    }
}
