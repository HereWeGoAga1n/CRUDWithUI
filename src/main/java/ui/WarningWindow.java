package ui;

import javax.swing.*;
import java.awt.*;

public class WarningWindow {
    Container container;

    public WarningWindow(){
        JFrame jFrame = new JFrame("Warning");
        container = new Container(jFrame);

        JLabel Label = new JLabel();
        Label.setFont(new Font("Verdana", 0, 12));
        Label.setText("You wrote incorrect data");
        Label.setBounds(60, 50, 80, 20);

        JButton btnExit = new JButton("Okay");

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("CRUD");
        jFrame.setResizable(false);


        jFrame.setBounds(0, 0, 300, 200);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(btnExit);
        jFrame.add(Label);
        jFrame.setVisible(true);

    }
}
