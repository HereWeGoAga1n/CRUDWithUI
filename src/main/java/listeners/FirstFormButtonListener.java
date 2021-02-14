package listeners;

import ui.FileDBChooserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFormButtonListener implements ActionListener {

    JButton readBtn;
    JButton createBtn;
    JButton exitBtn;
    FileDBChooserPanel fileDBChooserPanel;

    public FirstFormButtonListener(JButton readBtn, JButton createBtn, JButton exitBtn) {
        this.readBtn = readBtn;
        this.createBtn = createBtn;
        this.exitBtn = exitBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == readBtn) {
            fileDBChooserPanel = new FileDBChooserPanel();
        }
    }
}
