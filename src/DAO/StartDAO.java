package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StartDAO {

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:mydatabase.sqlite";
        Connection conn = DriverManager.getConnection(url);
        System.out.println("Done");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connect();
    }

}

