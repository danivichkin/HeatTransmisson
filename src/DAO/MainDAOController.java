package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ObjectName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class MainDAOController {

    private final static String url = "jdbc:sqlite:src/resources/database/mydatabase.sqlite";

    public static ObservableList<?> loadFromDB() throws SQLException{
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Materials");
        ObservableList<String> data = FXCollections.observableArrayList();
        data.setAll(String.valueOf(resultSet));
        statement.close();
        return data;
    }

    public static ArrayList onlyNameOfObject() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name from Materials");
        ArrayList<String> names = new ArrayList<String>();
        while (resultSet.next()){
            names.add(resultSet.getString("name"));
        }
        statement.close();
        return names;
    }

    public static ObservableList convertNameToObservable() throws SQLException {
        ObservableList<ObjectName> objectNames = FXCollections.observableArrayList();
        ArrayList names = MainDAOController.onlyNameOfObject();
        ArrayList<ObjectName> objectNames1 = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            objectNames1.add(new ObjectName((String) names.get(i)));
        }
        objectNames.setAll(objectNames1);
        return objectNames;
    }

    public static void removeSelectedObject(String objectName) throws SQLException {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Materials where name = ?");
            preparedStatement.setString(1, String.valueOf(objectName));
            preparedStatement.executeUpdate();
    }

    public static void changeSelectedObject(){

    }

}
