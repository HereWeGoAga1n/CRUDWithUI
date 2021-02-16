package ui;

import org.json.simple.parser.ParseException;
import project2.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static project2.FormatFactory.instance;

public class Table {


    private final JFrame jFrame;
    private final Container container;
    private JScrollPane jScrollPane;
    DefaultTableModel defaultTableModel;
    JTable jTable;

    public Table(JFrame jFrame, Container container) {
        this.jFrame = jFrame;
        this.container = container;

    }


    public void drawTable() throws ParseException, IOException, ClassNotFoundException {
        List<Person> personList;
        if (container.getFileName().equals("")) {
            personList = new ArrayList<>();
        } else {
            personList = instance.read();
        }
       defaultTableModel  = new DefaultTableModel(new Object[][]{}, new Object[]{"id", "fname", "lname", "age", "city"});
        for (Person person : personList) {
            defaultTableModel.addRow(new String[]{String.valueOf(person.getId()), person.getFname(), person.getLname(), String.valueOf(person.getAge()), person.getCity()});
        }
        jTable = new JTable(defaultTableModel);
        jTable.setFillsViewportHeight(true);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(15, 200, 465, 185);
        jFrame.add(jScrollPane);
    }

    public long getActiveRow(){
        int row = jTable.getSelectedRow();
        long id = Long.parseLong((String) jTable.getValueAt(row, 0));
        System.out.println(id);
        return id;
    }

    public void redrawTable() throws ParseException, IOException, ClassNotFoundException {
        jFrame.remove(jScrollPane);
        drawTable();
    }


}
