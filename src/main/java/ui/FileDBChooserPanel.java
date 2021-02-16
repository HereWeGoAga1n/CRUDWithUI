package ui;

import listeners.DBPanelButtonListener;
import listeners.FileDBChooserButtonListener;
import listeners.MainFormButtonListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FileDBChooserPanel {
    public static JFrame frame;
    public static JPanel panel;
    JButton fileB;
    JButton dbB;
    ActionListener listener;

    public FileDBChooserPanel() {
        frame = new JFrame();
        panel = new JPanel();
        fileB = new JButton("From file");
        dbB = new JButton("From DB");

        panel.add(fileB);
        panel.add(dbB);

        listener = new FileDBChooserButtonListener(fileB, dbB);
        fileB.addActionListener(listener);
        dbB.addActionListener(listener);


        frame.setLayout(null);
        panel.setBounds(50,50,400,100);
        frame.setSize(500,200);
        frame.add(panel);
        frame.setVisible(true);
    }


}
