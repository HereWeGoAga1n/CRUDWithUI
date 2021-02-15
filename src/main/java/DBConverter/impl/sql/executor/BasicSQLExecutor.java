package DBConverter.impl.sql.executor;

import DBConverter.IDBConverter;

import project1.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class BasicSQLExecutor implements IDBConverter {

    public abstract Connection connectionSettings();
    Person person = new Person();


    @Override
    public void writeToDB(Person person) {
        try {
            String sql = "INSERT INTO persons (id,first_name,last_name,age,city) VALUES (?,?,?,?,?)"; //Писать название таблиц одинаково!!
            PreparedStatement preparedStatement = connectionSettings().prepareStatement(sql); //CONST CONNECTION
            preparedStatement.setString(1, String.valueOf(person.getId()));
            preparedStatement.setString(2, person.getFname());
            preparedStatement.setString(3, person.getLname());
            preparedStatement.setString(4, String.valueOf(person.getAge()));
            preparedStatement.setString(5, person.getCity());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Add new user");
            }
            connectionSettings().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readFromDB() {
        List<Person> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connectionSettings().createStatement(); //CONST CONNECTION
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Person person = new Person();
                String username = result.getString(2);
                String email = result.getString(3);
                String fullname = result.getString(4);
                String password = result.getString(5);
                System.out.println("Name: '" + username + "', Email: '" + email + "', Full Name: '" + fullname);
                userList.add(person);
            }
            connectionSettings().close(); //CONST CONNECTION
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void updateInDB(long id, String[] newArray) {
        try {
            String sql = "UPDATE users SET username=?,email=?,fullname=?,password=? WHERE username=?";
            PreparedStatement preparedStatement = connectionSettings().prepareStatement(sql); //CONST CONNECTION
            preparedStatement.setString(1, "Hasan");
            preparedStatement.setString(2, "hasan.ty@gmail.com");
            preparedStatement.setString(3, "SUSLAN");
            preparedStatement.setString(4, "QWERTY");
            preparedStatement.setString(5, "Vitya");
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("User info was updated!");
            }
            connectionSettings().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromDB(long id) {
        try {
            String sql = "DELETE FROM users WHERE username=?";
            PreparedStatement preparedStatement = connectionSettings().prepareStatement(sql); //CONST CONNECTION
            preparedStatement.setString(1,"user.getEmail()"); // id ?!!!
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("User info was deleted !");
            }
            connectionSettings().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

