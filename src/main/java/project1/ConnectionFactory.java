package project1;

import util.Constants.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //TO DO: ConnectionFactory should be removed, Format Factory should be used instead!!!!!

    Connection connectionToMySQL;
    Connection connectionToMariaDB;
    Connection connectionToPostgreSQL;
    Connection connectionToMongoDB;
    public static Connection instance;

    public ConnectionFactory() throws SQLException {
        connectionToMySQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/persons_db", "root", "dg789H4578J");
        connectionToMariaDB = DriverManager.getConnection("jdbc:mysql://localhost:3308/testdb", "root", "root");
        connectionToPostgreSQL = DriverManager.getConnection("jdbc:mysql://localhost:5432/simpledb", "root", "root");
        connectionToMongoDB = DriverManager.getConnection("jdbc:mysql://localhost:5432/simpledb", "root", "root");
    }

    public Connection getInstance(String format) {
        switch (format.toLowerCase()) {
            case DB.MY_SQL:
                instance = connectionToMySQL;
                break;
            case DB.MARIA_DB:
                instance = connectionToMariaDB;
                break;
            case DB.POSTGRE_SQL:
                instance = connectionToPostgreSQL;
                break;
            case DB.MONGO_DB:
                instance = connectionToMongoDB;
                break;
            default:
                throw new IllegalArgumentException("Данная программа не работает введенным форматом.\n");
        }
        return instance;
    }
}
