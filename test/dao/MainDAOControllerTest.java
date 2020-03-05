package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Material;
import models.ObjectName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class MainDAOControllerTest {

    @org.junit.jupiter.api.Test
    void loadFromDB() throws IOException {
        FileReader fileReader = new FileReader("src/resources/database/default");
        Scanner scan = new Scanner(fileReader);
        ArrayList<String> data = new ArrayList<>();
        while (scan.hasNextLine()) {
            data.add(scan.nextLine());
        }
        System.out.println(data);
        fileReader.close();
    }

    @org.junit.jupiter.api.Test
    void loadFromDb() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:src/resources/database/mydatabase.sqlite");
        Statement statement = conn.createStatement();
        System.out.println("Ready");
        ResultSet resultSet = statement.executeQuery("SELECT * from Materials");
        ObservableList<String> data = FXCollections.observableArrayList();
        data.setAll(String.valueOf(resultSet));
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + "\t" +
                            resultSet.getInt("type") + "\t" +
                            resultSet.getDouble("A") + "\t" +
                            resultSet.getDouble("B") + "\t" +
                            resultSet.getDouble("C") + "\t" +
                            resultSet.getDouble("plotnost") + "\t");
        }
    }

    @Test
    void onlyNameOfObject() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database/mydatabase.sqlite");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name from Materials");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
    }

    @Test
    void parsersToString() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database/mydatabase.sqlite");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name from Materials");
        ArrayList<String> names = new ArrayList<>();
        while (resultSet.next()){
            names.add(resultSet.getString("name"));
        }
        System.out.println(names);
    }

    @Test
    void n() throws SQLException {
        ObservableList<ObjectName> objectNames = FXCollections.observableArrayList();
        ArrayList names = MainDAOController.onlyNameOfObject();
        ArrayList<ObjectName> objectNames1 = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            objectNames1.add(new ObjectName((String) names.get(i)));
        }
        objectNames.setAll(objectNames1);
        }

    @Test
    void removeSelectedObject() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database/mydatabase.sqlite");
        PreparedStatement preparedStatement = connection.prepareStatement("delete from Materials where name = ?");
        preparedStatement.setString(1, "1");
        preparedStatement.executeUpdate();
    }

    @Test
    void getObjectByName() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database/mydatabase.sqlite");
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, type, a, b, c," +
                "plotnost from Materials where name = ?");
        preparedStatement.setString(1, "1111");
        Material material = new Material();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            material.setName(resultSet.getString("name"));
            material.setType(resultSet.getInt("type"));
            material.setA(resultSet.getDouble("A"));
            material.setB(resultSet.getDouble("B"));
            material.setC(resultSet.getDouble("C"));
            material.setPlotnost(resultSet.getDouble("plotnost"));
        }
        System.out.println(material.toString());
        }
    }
