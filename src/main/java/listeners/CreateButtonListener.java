package listeners;

import project1.model.Person;
import ui.CRUDmenu;
import ui.NameNewFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateButtonListener implements ActionListener {

    //ToDo получение fileName и Executor с Container получение с полей их значения и создание новой
    // персоный с этими значениями и выполнение метода extcutor.create и container.getTable.redrawTable()
    private final Container container;
    private final JTextField txtId;
    private final JTextField txtFname;
    private final JTextField txtLname;
    private final JTextField txtAge;
    private final JTextField txtCity;

    public CreateButtonListener(Container container, JTextField txtId, JTextField txtFname, JTextField txtLname, JTextField txtAge, JTextField txtCity) {
        this.container = container;
        this.txtId = txtId;
        this.txtFname = txtFname;
        this.txtLname = txtLname;
        this.txtAge = txtAge;
        this.txtCity = txtCity;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Person person = createPerson();
        try{
            person.setId(Integer.parseInt(txtId.getText()));
            person.setFname(txtFname.getText());
            person.setLname(txtLname.getText());
            person.setAge(Integer.parseInt(txtAge.getText()));
            person.setCity(txtCity.getText());
        }catch (NullPointerException x){
            CRUDmenu mm = new CRUDmenu();
        }
        if(container.getPersonList() == null){
            ArrayList<Person> personList = new ArrayList();
            personList.add(person);
            container.setPersonList(personList);
        }else{
            ArrayList personList = container.getPersonList();
            personList.add(person);
        }


        NameNewFile nameNewFile = new NameNewFile();


    }


    private Person createPerson(){
        return new Person();
    }
}
