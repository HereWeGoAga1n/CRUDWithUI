package databases.impl.sql.executor;

import databases.impl.IDataBaseModel;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class BasicSQLExecutor implements IDataBaseModel {

    public abstract Connection connectionSettings();
    User user = new User();


    @Override
    public void writeToDB(User user) {
        try {
            String sql = "INSERT INTO users (username, email,fullname,)" + " VALUES (?,?,?)"; //Писать название таблиц одинаково!!
            PreparedStatement preparedStatement = connectionSettings().prepareStatement(sql); //CONST CONNECTION
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getFullname());
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
    public List<User> readFromDB() {
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connectionSettings().createStatement(); //CONST CONNECTION
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                User user = new User();
                String username = result.getString(2);
                String email = result.getString(3);
                String fullname = result.getString(4);
                String password = result.getString(5);
                System.out.println("Name: '" + username + "', Email: '" + email + "', Full Name: '" + fullname);
                userList.add(user);
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
            preparedStatement.setString(1,user.getEmail()); // id ?!!!
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
