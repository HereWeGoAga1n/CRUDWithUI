package DBConverter.impl.sql;

import DBConverter.impl.sql.executor.BasicSQLExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL extends BasicSQLExecutor {
    @Override
    public Connection connectionSettings() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:5432/simpledb";
            String name = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, name, pass);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
