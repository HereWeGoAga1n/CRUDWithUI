package listeners;

import org.json.simple.parser.ParseException;
import project2.cmd.Executable;
import project2.model.Person;
import ui.FileDBChooserPanel;
import ui.NewFileCreator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static ui.Container.table;
import static project2.io.OpenDocument.executable;

public class MainFormButtonListener implements ActionListener {
    JButton btnRead;
    JButton btnUpdate;
    JButton btnSave;
    JButton btnDelete;
    JButton btnExit;
    JTextField txtId;
    JTextField txtFname;
    JTextField txtLname;
    JTextField txtAge;
    JTextField txtCity;
    JTextField fileName;
    JComboBox fileType;
    public static int returnVal;
    public static FileDBChooserPanel fileDBChooserPanel;
    Executable executable;
    ArrayList<Person> arrayList;
    Person person;

    public MainFormButtonListener(JButton btnRead, JButton btnUpdate, JButton btnCreate, JButton btnDelete, JButton btnExit,
                                  JTextField txtId, JTextField txtFname, JTextField txtLname, JTextField txtAge, JTextField txtCity) {
        this.btnRead = btnRead;
        this.btnUpdate = btnUpdate;
        this.btnSave = btnCreate;
        this.btnDelete = btnDelete;
        this.btnExit = btnExit;
        this.txtId = txtId;
        this.txtFname = txtFname;
        this.txtLname = txtLname;
        this.txtAge = txtAge;
        this.txtCity = txtCity;
    }

    public MainFormButtonListener(JTextField nameField, JComboBox comboBox) {
        fileName = nameField;
        fileType = comboBox;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == btnRead) {
            fileDBChooserPanel = new FileDBChooserPanel();
        } else if (source == btnDelete){
            long id = table.getActiveRow();
            try {
                executable.delete(id);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }else if(source == btnSave){
            person = new Person();
            arrayList = new ArrayList<>();
            person.setId(Integer.parseInt(txtId.getText()));
            person.setFname(txtFname.getText());
            person.setLname(txtLname.getText());
            person.setAge(Integer.parseInt(txtAge.getText()));
            person.setCity(txtCity.getText());
            arrayList.add(person);
            NewFileCreator newFileCreator = new NewFileCreator();
            Path path = Paths.get("C:\\Users\\DeadCrawler\\Desktop", fileName.getText()+ "." + fileType.getActionCommand());
            File file = new File(String.valueOf(path));
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                System.out.println(person.toString());
                executable.create(arrayList);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }
}
