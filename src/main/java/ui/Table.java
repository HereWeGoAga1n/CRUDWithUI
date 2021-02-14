package ui;

import listeners.Container;
import project1.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Table {


    private final JFrame jFrame;
    private final Container container;
    private JScrollPane jScrollPane;


    public Table(JFrame jFrame, Container container) {
        this.jFrame = jFrame;
        this.container = container;

    }


    public void drawTable() {
        List<Person> personList;
        if (container.getFileName().equals("")) {
            personList = new ArrayList<>();
        } else {
            personList = new ArrayList<>();
//            personList = container.getFileExecutor().read(container.getFileName());
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"id", "fname", "lname", "age", "city"});
        for (Person person : personList) {
            defaultTableModel.addRow(new String[]{String.valueOf(person.getId()), person.getFname(), person.getLname(), String.valueOf(person.getAge()), person.getCity()});
        }
        JTable jTable = new JTable(defaultTableModel);
        jTable.setFillsViewportHeight(true);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(15, 200, 465, 185);
        jFrame.add(jScrollPane);
    }

    public void redrawTable() {
        jFrame.remove(jScrollPane);
        drawTable();
    }
}

