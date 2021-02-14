package listeners;

import ui.FileDBChooserPanel;
import ui.FileCreateChooserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormButtonListener implements ActionListener {
    JButton readB;
    JButton updateB;
    JButton createB;
    JButton removeB;
    JButton exitB;
    public static int returnVal;
    public static FileDBChooserPanel fileDBChooserPanel;
    public static FileCreateChooserPanel fileCreateChooserPanel;

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
        }else if(source == createB){
            fileCreateChooserPanel = new FileCreateChooserPanel();
        }

    }
}
