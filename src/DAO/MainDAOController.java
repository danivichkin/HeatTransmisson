package DAO;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MainDAOController {

    public static ObservableList<String> loadFromDB(Connection connection) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from models");
        ObservableList<String> data = FXCollections.observableArrayList();
        data.setAll(String.valueOf(resultSet));
        System.out.println(data);
        return data;
    }

    public static ObservableList onlyNameOfObject(ObservableList array){
        ObservableList objectNames = FXCollections.observableArrayList();
        for (int i = 0; i < array.size(); i++) {
        }
        return objectNames;
    }
}
