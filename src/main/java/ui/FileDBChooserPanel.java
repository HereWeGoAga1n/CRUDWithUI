package ui;

import listeners.DBPanelButtonListener;
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
    JRadioButton mysqlB;
    JRadioButton mariadbB;
    JRadioButton postgresqlB;
    JRadioButton mangodbB;
    JPanel dbPanel;
    JButton okB;

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
        dbPanel = new JPanel();
        mysqlB = new JRadioButton("MySQL");
        mariadbB = new JRadioButton("MariaDB");
        postgresqlB = new JRadioButton("PostgreSQL");
        mangodbB = new JRadioButton("MangoDB");
        okB = new JButton("OK");



        ActionListener listener = new DBPanelButtonListener(okB, dbPanel);
        okB.addActionListener(listener);

        dbPanel.setBounds(50,50,400,50);
        dbPanel.add(mysqlB);
        dbPanel.add(mariadbB);
        dbPanel.add(postgresqlB);
        dbPanel.add(mangodbB);

        frame.getContentPane().remove(panel);
        frame.getContentPane().add(dbPanel);
        frame.repaint();
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        okB.setBounds(200,100,100,30);
        frame.add(okB);
        okB.setVisible(true);
    }
}
