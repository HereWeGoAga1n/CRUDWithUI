package listeners;

import org.json.simple.parser.ParseException;
import ui.FileDBChooserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    public static int returnVal;
    public static FileDBChooserPanel fileDBChooserPanel;

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
        }
    }
}
