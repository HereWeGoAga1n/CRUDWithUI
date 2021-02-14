package DBConverter.impl.sql;

import DBConverter.impl.sql.executor.BasicSQLExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2 extends BasicSQLExecutor {

    @Override
    public Connection connectionSettings() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:h2:./H2";
            String name = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, name, pass);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;    }
}
