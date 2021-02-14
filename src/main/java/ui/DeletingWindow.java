package ui;

import ui.ButtonListeners.Container;
import ui.ButtonListeners.DeleteButtonListener;
import ui.ButtonListeners.DeleteListener;
import ui.ButtonListeners.FileFormatListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletingWindow {

    public DeletingWindow(){

        JFrame jFrame = new JFrame("Are you sure???");
        Container container = new Container(jFrame);

        JLabel idSelect = new JLabel();
        idSelect.setFont(new Font("Verdana", 0, 12));
        idSelect.setText("Select current id you want to delete");
        idSelect.setBounds(50,60, 300, 30);

        JTextField txtId = new JTextField();
        txtId.setBounds(50,60,300,30);

        JButton jButton = new JButton();
        jButton.setText("Delete");
        jButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        jButton.setIconTextGap(0);
        jButton.setInheritsPopupMenu(true);
        jButton.setBounds(50, 100, 130, 30);
        ActionListener btnListener = new SureWindow(txtId);
        jButton.addActionListener(btnListener);

        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setTitle("Select current id you want to Delete");
        jFrame.setResizable(false);

        jFrame.setBounds(0,0, 400,200);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(idSelect);
        jFrame.add(txtId);
        jFrame.setVisible(true);
    }
    public static class SureWindow implements ActionListener {
        private JTextField filename;

        public SureWindow(JTextField filename) {
            JFrame jFrame = new JFrame();
            Container container = new Container(jFrame);

            JLabel sure = new JLabel();
            sure.setFont(new Font("Verdana", 0, 12));
            sure.setText("Are You sure?");
            sure.setBounds(40, 50, 300, 30);

            JButton yes = new JButton();
            yes.setText("YES");
            yes.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            yes.setIconTextGap(0);
            yes.setInheritsPopupMenu(true);
            yes.setBounds(50, 100, 130, 30);
            ActionListener btnListener = new FileFormatListener(container, this.filename = filename);
            yes.addActionListener(btnListener);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

}

