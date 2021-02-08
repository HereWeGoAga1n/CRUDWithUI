package ui;

import listeners.FileDBChooserButtonListener;
import listeners.MainFormButtonListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FileDBChooserPanel {
    JFrame frame;
    JPanel panel;
    public static JButton fileB;
    public static JButton dbB;
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

    public void changeToDBPanel(){
        JPanel dbPanel = new JPanel();
        JRadioButton mysqlB = new JRadioButton();
        JRadioButton mariadbB = new JRadioButton();
        JRadioButton postgresqlB = new JRadioButton();
        JRadioButton mangodbB = new JRadioButton();
        panel.add(mysqlB);
        panel.add(mariadbB);
        panel.add(postgresqlB);
        panel.add(mangodbB);
        panel.setVisible(true);

        frame.removeAll();
        frame.revalidate();
        frame.repaint();
        frame.add(dbPanel);
    }
}
