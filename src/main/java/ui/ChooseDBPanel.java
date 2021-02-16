package ui;

import listeners.DBPanelButtonListener;

import javax.swing.*;
import java.awt.event.ActionListener;
import static ui.FileDBChooserPanel.frame;
import static ui.FileDBChooserPanel.panel;

public class ChooseDBPanel {
    JRadioButton mysqlB;
    JRadioButton mariadbB;
    JRadioButton postgresqlB;
    JRadioButton mangodbB;
    JPanel dbPanel;
    JButton okB;
    ButtonGroup buttonGroup;

    public ChooseDBPanel() {
        buttonGroup = new ButtonGroup();
        dbPanel = new JPanel();
        mysqlB = new JRadioButton("MySQL");
        mariadbB = new JRadioButton("MariaDB");
        postgresqlB = new JRadioButton("PostgreSQL");
        mangodbB = new JRadioButton("MangoDB");
    }


    public void changeToDBPanel(){
        okB = new JButton("OK");
        buttonGroup.add(mysqlB);
        buttonGroup.add(mariadbB);
        buttonGroup.add(postgresqlB);
        buttonGroup.add(mangodbB);

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
