package project1.cmd;

import org.json.simple.parser.ParseException;
import project1.model.Person;
import ui.SomeReadEditUI;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static ui.SomeReadEditUI.getConnection;

public class DBCmdProcessor implements Executable {


    @Override
    public void create(List<Person> persons) throws IOException, ParseException, ClassNotFoundException {
        try {
            if (!tableExists()) {
                createTable();
            }
            String sql = "INSERT INTO users (username, email,fullname,password)" + " VALUES (?,?,?,?)"; //Писать название таблиц одинаково!!

            PreparedStatement preparedStatement = SomeReadEditUI.getConnection().prepareStatement(sql);
            preparedStatement.setString(3, "user.getFullName()");
            preparedStatement.setString(1, "Hasan");
            preparedStatement.setString(2, "hasan.ty@gmail.com");
            preparedStatement.setString(3, "Ibrahim");
            preparedStatement.setString(4, "salam123");
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Add new user");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private boolean tableExists() throws SQLException {
        DatabaseMetaData dbm = SomeReadEditUI.getConnection().getMetaData();
// check if "employee" table is there
        ResultSet tables = dbm.getTables(null, null, "person", null);
        return tables.next();
    }

    private boolean createTable() throws ClassNotFoundException {
  //      String tableName = "persons";
  //      String column1 = "Id";
  //      String column1Type = "int";
  //      String column2 = "name";
  //      String column2Type = "varchar(30)";
  //      Class.forName("com.mysql.jdbc.Driver");
  //      String url = "jdbc:mysql://localhost:3306/sample";
  //      Connection connection = DriverManager.getConnection(url, "username", "password");
  //      Statement stmt = connection.createStatement();
  //      String query = "create table " + tableName + " ( " + column1+" " + column1Type +  " , " +
  //              column2 +" " + column2Type + " )";
  //      System.out.printf(query);
  //      stmt.executeUpdate(query);
  //      stmt.close();
        return false;
    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public List<Person> read() throws IOException, ParseException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement statement = SomeReadEditUI.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Person person = new Person();
                String username = result.getString(2);
                person.setFname(username);
                String email = result.getString(3);
                String fullname = result.getString(4);
                person.setLname(fullname);
                String password = result.getString(5);
                System.out.println("Name: '" + username + "', Email: '" + email + "', Full Name: '" + fullname + "', Password: '" + password);
            }
            SomeReadEditUI.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return persons;
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException {
        try {
            String sql = "UPDATE users SET username=?,email=?,fullname=?,password=? WHERE username=?";
            PreparedStatement preparedStatement = SomeReadEditUI.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "Hasan");
            preparedStatement.setString(2, "hasan.ty@gmail.com");
            preparedStatement.setString(3, "SUSLAN");
            preparedStatement.setString(4, "QWERTY");
            preparedStatement.setString(5, "Vitya");
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("User info was updated!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) throws IOException, ParseException, ClassNotFoundException {
        try {
            String sql = "DELETE FROM users WHERE username=?";
            PreparedStatement preparedStatement = SomeReadEditUI.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "Hasan");
            int rows = preparedStatement.executeUpdate(); // !!! TUT
            if (rows > 0) {
                System.out.println("User info was deleted !");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
