package listeners;

import project1.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBPanelButtonListener implements ActionListener {

    JButton okB;
    JPanel dbPanel;
    ConnectionFactory connectionFactory;
    public DBPanelButtonListener(JButton okB, JPanel dbPanel) {
        this.okB = okB;
        this.dbPanel = dbPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Component c : dbPanel.getComponents()){
            JRadioButton radioButton = (JRadioButton) c;
            if (radioButton.isSelected()){
                connectionFactory.getInstance(radioButton.getText());
            }
        }
    }
}
