package ui;

import project1.ConnectionFactory;
import project1.FormatFactory;

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
