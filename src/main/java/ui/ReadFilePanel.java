package ui;

import listeners.MainFormButtonListener;
import listeners.ReadFilePanelBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReadFilePanel extends JPanel {
    public static final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public ReadFilePanel() {
        super(new BorderLayout());

        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        fc = new JFileChooser();

        ActionListener listener = new ReadFilePanelBL(openButton, saveButton, log, fc);

        openButton = new JButton("Open a File...");
        openButton.addActionListener(listener);

        saveButton = new JButton("Save a File...");
        saveButton.addActionListener(listener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
