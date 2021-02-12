package ui;

import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class MainMenu extends JFrame {

    Connection con;
    Statement st;

    User user = new User();

    public MainMenu() {
        initComponents();
//        fetch();
    }


    private void initComponents() {

        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField txtLname = new javax.swing.JTextField();
        JTextField txtId = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new javax.swing.JTable();
        JButton btnSave = new javax.swing.JButton();
        JButton btnUpdate = new javax.swing.JButton();
        JButton btnDelete1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new Font("Verdana", 0, 12));
        jLabel3.setText("Id");


        txtLname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        txtId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "First Name", "Last Name", "Id Number"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable.setCellSelectionEnabled(true);
        jTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });

        /*
        jScrollPane1.setViewportView();
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(2).setResizable(false);
        }
        */

        btnSave.setText("Save");
        btnSave.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("Delete");
        btnDelete1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnDelete1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new Font("Tahoma", 0, 18));
        jLabel4.setText("CRUD APPLICATION");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtId, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                        .addComponent(txtLname)
                                                        .addComponent(txtFname))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(254, 254, 254))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDelete1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(43, 43, 43)));
        pack();
        setLocationRelativeTo(null);
    }


    private void btnSaveActionPerformed(ActionEvent evt) {

        // TODO add your handling code here:

        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JTextField txtLname = new JTextField();
        JTextField txtId = new JTextField();
        JLabel jLabel3 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new JTable();
        JButton btnSave = new JButton();
        JButton btnUpdate = new JButton();
        JButton btnDelete1 = new JButton();
        JLabel jLabel4 = new JLabel();


        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String id = txtId.getText().trim();

        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
                String sql = "select * from person where id_number='" + id + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (!rs.first()) {
                    savePerson(fname, lname, id);
                    DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                    Object[] row = new Object[4];
                    row[0] = fname;
                    row[1] = lname;
                    row[2] = id;
                    model.addRow(row);
                } else {
                    alert("Please provide a different id number", "Similar id found");
                }

                clear();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            alert("please fill in all the details");
        }
    }

    private void btnUpdateActionPerformed(ActionEvent evt) {

        // TODO add your handling code here:

        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField txtLname = new javax.swing.JTextField();
        JTextField txtId = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new javax.swing.JTable();
        JButton btnSave = new javax.swing.JButton();
        JButton btnUpdate = new javax.swing.JButton();
        JButton btnDelete1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();

        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String id = txtId.getText().trim();
        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
                String sql = "select * from person where id_number='" + id + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.first()) {
                    update(fname, lname, id);
                    DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                    model.setRowCount(0);
//                    fetch();
                    alert("Update was successful");

                } else {
                    alert("There is no such person", "Update error");
                    clear();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alert("There is nothing to update :(", "No row selected");
        }
    }

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {

        // TODO add your handling code here:

        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField txtLname = new javax.swing.JTextField();
        JTextField txtId = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new javax.swing.JTable();
        JButton btnSave = new javax.swing.JButton();
        JButton btnUpdate = new javax.swing.JButton();
        JButton btnDelete1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();

        int i = jTable.getSelectedRow();
        TableModel model = jTable.getModel();
        txtFname.setText(model.getValueAt(i, 0).toString());
        txtLname.setText(model.getValueAt(i, 1).toString());
        txtId.setText(model.getValueAt(i, 2).toString());
    }

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {

        // TODO add your handling code here:

        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField txtLname = new javax.swing.JTextField();
        JTextField txtId = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new javax.swing.JTable();
        JButton btnSave = new javax.swing.JButton();
        JButton btnUpdate = new javax.swing.JButton();
        JButton btnDelete1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();

        int i = jTable.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = jTable.getModel();

                String id = model.getValueAt(i, 2).toString();
                if (jTable.getSelectedRows().length == 1) {
                    delete(id);
                    DefaultTableModel model1 = (DefaultTableModel) jTable.getModel();
                    model1.setRowCount(0);
                    clear();
                }
            }
        } else {
            alert("Please select a row to delete");
        }
    }

    private void txtLnameActionPerformed(ActionEvent event) {


    }

    private void txtIdActionPerformed(ActionEvent event) {


    }


    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }


    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }


    public void savePerson(String fname, String lname, String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "INSERT INTO `persons`(`fname`, `lname`, `id_number`) "
                    + "VALUES ('" + fname + "','" + lname + "','" + id + "')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void update(String fname, String lname, String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "UPDATE `persons`SET fname='" + fname + "',lname='" + lname + "'WHERE id_number='" + id + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //delete details in the db
    public void delete(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "DELETE FROM `persons` WHERE id_number='" + id + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //method to clear the txt fields
    private void clear() {
        JTextField txtFname = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField txtLname = new javax.swing.JTextField();
        JTextField txtId = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable = new javax.swing.JTable();
        JButton btnSave = new javax.swing.JButton();
        JButton btnUpdate = new javax.swing.JButton();
        JButton btnDelete1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();

        txtFname.setText("");
        txtLname.setText("");
        txtId.setText("");
    }


    /*private void fetch() {
        JTable jTable = new javax.swing.JTable();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            String sql = "select * from persons";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<Person> person = new Person(rs.getString("fname"), rs.getString("lname"), rs.getString("id_number"));
                personList.add(String.valueOf(person));
            }
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            for (Person person : personList) {
                Object[] row = new Object[4];
                row[0] = person.getFname();
                row[1] = person.getLname();
                row[2] = person.getId();
                model.addRow(row);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
