package ui;

import javax.swing.*;

public class MainForm {
    JFrame frame;
    JPanel panel;
    JButton readB;
    JButton updateB;
    JButton createB;
    JButton removeB;
    JButton exitB;

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

        frame.add(panel);
        frame.setVisible(true);
    }
}
