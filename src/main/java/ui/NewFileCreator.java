package ui;

import listeners.ComboBoxListener;
import listeners.MainFormButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static util.Constants.Format.*;

public class NewFileCreator {
    public static Container container;

    public NewFileCreator(){
        JFrame jFrame = new JFrame("CREATE");
        container = new Container(jFrame);

        JLabel typeLabel = new JLabel();
        typeLabel.setFont(new Font("Verdana", 0, 12));
        typeLabel.setText("Select type you need");
        typeLabel.setBounds(90, 50, 200, 20);

        JLabel nameLabel = new JLabel();
        nameLabel.setFont(new Font("Verdana", 0, 12));
        nameLabel.setText("File name: ");
        nameLabel.setBounds(90, 50, 200, 20);


        JTextField nameField = new JTextField();
        nameField.setBounds(90, 150, 80, 20);


        JComboBox comboBox = new JComboBox(new String[]{XML, YAML, CSV, JSON, BINARY, H2, POSTGRE_SQL, MY_SQL, MONGO_DB,
        REDIS,      CASSANDRA,
        NEO_4J});
        comboBox.setFont(new Font("Verdana", 0, 12));
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBox.setBounds(90, 70, 150, 30);


        JButton create = new JButton();
        create.setText("CREATE");
        create.setBounds(90, 160, 150, 30);
        ActionListener createListener = new MainFormButtonListener(nameField, comboBox);
        create.addActionListener(createListener);

        jFrame.add(comboBox);
        jFrame.add(nameField);
        jFrame.add(typeLabel);
        jFrame.add(create);
        jFrame.add(typeLabel);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("FILE CREATOR");
        jFrame.setResizable(false);

        jFrame.setBounds(0, 0, 450, 350);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
