package ui;

import listeners.MainFormButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainForm {
    JFrame frame;
    JPanel panel;
    public static JButton readB;
    public static JButton updateB;
    public static JButton createB;
    public static JButton removeB;
    public static JButton exitB;
    ActionListener listener;

    public MainForm() {
        frame = new JFrame();
        panel = new JPanel();
        readB = new JButton("Read data");
        updateB = new JButton("Update record");
        createB = new JButton("Create new record");
        removeB = new JButton("Remove record");
        exitB = new JButton("Exit");

        panel.add(readB);
        panel.add(updateB);
        panel.add(createB);
        panel.add(removeB);
        panel.add(exitB);

        listener = new MainFormButtonListener(readB, updateB, createB, removeB, exitB);
        readB.addActionListener(listener);
        updateB.addActionListener(listener);
        createB.addActionListener(listener);
        removeB.addActionListener(listener);
        exitB.addActionListener(listener);

        frame.setLayout(null);
        panel.setBounds(50,50,400,100);
        frame.setSize(500,200);
        frame.add(panel);
        frame.setVisible(true);
    }
}
