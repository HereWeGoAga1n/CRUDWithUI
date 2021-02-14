package ui;

import model.Person;
import ui.ButtonListeners.Container;
import ui.ButtonListeners.FileFormatListener;


import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class NameNewFile {

        public NameNewFile(){
            JFrame jFrame = new JFrame("Name your file");
            Container container = new Container(jFrame);

            JLabel nameYourFile = new JLabel();
            nameYourFile.setFont(new Font("Verdana", 0, 12));
            nameYourFile.setText("Name Your file Please");
            nameYourFile.setBounds(50, 60, 300, 30);

            JTextField filename = new JTextField();
            filename.setBounds(50, 60, 300, 30);

            JComboBox comboBox = new JComboBox(new String[] {"Cassandra",
                        "MongoDB",
                        "Neo4J",
                        "Redis",
                        "H2",
                        "MySQL",
                        "PostgresSQL"});


            comboBox.setFont(new Font("Verdana", Font.PLAIN, 11));
            comboBox.setBounds(10, 10, 100, 30);
            comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
            ActionListener comboBoxListener = new FileFormatListener(comboBox);
            comboBox.addActionListener(comboBoxListener);

            JButton btn = new JButton();
            btn.setText("Continue");
            btn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            btn.setIconTextGap(0);
            btn.setInheritsPopupMenu(true);
            btn.setBounds(50, 100, 130, 30);
            ActionListener btnListener = new FileFormatListener(container, filename);
            btn.addActionListener(btnListener);


            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jFrame.setTitle("Name your file, chose format");
            jFrame.setResizable(false);

            jFrame.setBounds(0,0, 400,200);
            jFrame.setLayout(null);
            jFrame.setResizable(false);
            jFrame.setLocationRelativeTo(null);
            jFrame.add(nameYourFile);
            jFrame.add(filename);
            jFrame.add(btn);
            jFrame.add(comboBox);
            jFrame.setVisible(true);

        }


}

