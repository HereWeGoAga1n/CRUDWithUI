package listeners;

import org.json.simple.parser.ParseException;
import project1.model.Person;
import ui.Container;
import ui.MainMenu;
import ui.WarningWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CreateButtonListener implements ActionListener {
    JTextField fileName;
    JComboBox comboBox;
    Container container;
    JTextField txtId;
    JTextField txtFname;
    JTextField txtLname;
    JTextField txtAge;
    JTextField txtCity;

    public CreateButtonListener(Container container, JTextField filename, JComboBox comboBox) {
        this.comboBox = comboBox;
        this.fileName = filename;
        this.container = container;
    }

    public CreateButtonListener(JTextField txtId, JTextField txtFname, JTextField txtLname, JTextField txtAge, JTextField txtCity) {
        this.txtId = txtId;
        this.txtFname = txtFname;
        this.txtLname = txtLname;
        this.txtAge = txtAge;
        this.txtCity = txtCity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        try{
            person.setId(Integer.parseInt(txtId.getText()));
            person.setFname(txtFname.getText());
            person.setLname(txtLname.getText());
            person.setAge(Integer.parseInt(txtAge.getText()));
            person.setCity(txtCity.getText());
        }catch (NullPointerException x){
            WarningWindow warningWindow = new WarningWindow();
        }
    }
}
