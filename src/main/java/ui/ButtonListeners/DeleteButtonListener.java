package ui.ButtonListeners;

import ui.DeletingWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonListener implements ActionListener {
    //ToDo получение fileName и Executor с Container получение с поля id  персоный с и выполнение метода extcutor.delete и container.getTable.redrawTable()

    private final Container container;

    public DeleteButtonListener(Container container) {
        this.container = container;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DeletingWindow delete = new DeletingWindow();
    }
}

