package ui;

import project2.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class SomeReadEditUI {

    public static ConnectionFactory factory = null;

    public SomeReadEditUI() throws SQLException {
        factory = new ConnectionFactory();
    }

    public static Connection getConnection(){
        return factory.getInstance("mysql");
    }
}
