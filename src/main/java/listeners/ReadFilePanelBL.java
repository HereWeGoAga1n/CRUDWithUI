package listeners;

import project1.io.SaveData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static ui.ReadFilePanel.newline;

public class ReadFilePanelBL extends JPanel implements ActionListener {
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;
    SaveData saveData;

    public ReadFilePanelBL(JButton openButton, JButton saveButton, JTextArea log, JFileChooser fc) {
        this.openButton = openButton;
        this.saveButton = saveButton;
        this.log = log;
        this.fc = fc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            saveData = new SaveData(log, fc);
            saveData.openFile();

        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(ReadFilePanelBL.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String absolutePath = file.getAbsolutePath();
                // change FileHelper getFile so it accepts File
                // OR get absolutePath here and giver it to FileHelper
                log.append("Saving: " + file.getName() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
}
