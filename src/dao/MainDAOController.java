package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Material;
import models.ObjectName;

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

    public static Material getObjectByName(ObjectName name) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, type, a, b, c," +
                "plotnost from Materials where name = ?");
        preparedStatement.setString(1, name.getName());
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
        return material;
    }

    public static void changeSelectedObject(Material material) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Materials VALUES " +
                "(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, material.getName());
        preparedStatement.setDouble(3, material.getType());
        preparedStatement.setDouble(4, material.getA());
        preparedStatement.setDouble(5, material.getB());
        preparedStatement.setDouble(6, material.getB());
        preparedStatement.setDouble(7, material.getPlotnost());
        preparedStatement.executeUpdate();
    }

}
