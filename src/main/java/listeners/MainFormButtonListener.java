package listeners;

import ui.FileDBChooserPanel;
import ui.NameNewFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public static CreateButtonListener createButtonListener;
    public static NameNewFile nameNewFile;

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
        System.out.println("MainFormButtonListener works");
        JButton source = (JButton) e.getSource();
        if (source == btnRead) {
            fileDBChooserPanel = new FileDBChooserPanel();
        }else if(source == btnSave){
            nameNewFile = new NameNewFile();
            createButtonListener = new CreateButtonListener(txtId, txtFname, txtLname, txtAge, txtCity);
        }
    }
}
