package ui;

import listeners.FirstFormButtonListener;
import listeners.MainFormButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstForm {
    JFrame frame;
    JPanel panel;
    public static JButton readB;
    public static JButton createB;
    public static JButton exitB;
    ActionListener listener;

    public FirstForm() {
        frame = new JFrame();
        panel = new JPanel();
        readB = new JButton("Read data");
        createB = new JButton("Create new record");
        exitB = new JButton("Exit");

        panel.add(readB);
        panel.add(createB);
        panel.add(exitB);

        listener = new FirstFormButtonListener(readB, createB,  exitB);
        readB.addActionListener(listener);
        createB.addActionListener(listener);
        exitB.addActionListener(listener);

        frame.setLayout(null);
        panel.setBounds(50,50,400,100);
        frame.setSize(500,200);
        frame.add(panel);
        frame.setVisible(true);
    }
}
