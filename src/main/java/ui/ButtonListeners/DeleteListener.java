package ui.ButtonListeners;

import ui.DeletingWindow;
import ui.NameNewFile;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private Container container;
    private JTextField txtId;

    public DeleteListener(Container container, JTextField txtId) {
        this.container = container;
        this.txtId = txtId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
