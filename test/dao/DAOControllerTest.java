package dao;

import models.Material;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DAOControllerTest {

    DAOControllerTest() throws SQLException {}

    private final static String url = "jdbc:sqlite:src/resources/database/mydatabase.sqlite";
    private  Connection connection = DriverManager.getConnection(url);


    private static final String SELECT = "SELECT * FROM MATERIALS";

    private static final String DELETE = "DELETE FROM materials WHERE id=?";

    private static final String INSERT_MATERIAL = " Insert into materials (name, type, coefficientA," +
            " coefficientB, coefficientC, density) VALUES (?, ?, ?, ?, ?, ?) ";

    private static final String UPDATE = "UPDATE materials SET name=?, type=?, coefficientA=?," +
            " coefficientB=?, coefficientC=?, density=?  where id=?";

    private static final String SELECT_BY_NAME = "SELECT name FROM materials";


    @Test
    void insert() throws SQLException {
        Material material = new Material("TestIntellij", "TypeTest" , 1.1, 1.1, 1.1 ,1.1);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATERIAL);
        preparedStatement.setString(1, material.getName());
        preparedStatement.setString(2, material.getType());
        preparedStatement.setString(3, String.valueOf(material.getCoefficientA()));
        preparedStatement.setString(4, String.valueOf(material.getCoefficientB()));
        preparedStatement.setString(5, String.valueOf(material.getCoefficientC()));
        preparedStatement.setString(6, String.valueOf(material.getDensity()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Test
    void select() throws SQLException {
        ArrayList<Material> arrayList = new ArrayList();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String type = resultSet.getString(3);
            Double coefficientA = resultSet.getDouble(4);
            Double coefficientB = resultSet.getDouble(5);
            Double coefficientC = resultSet.getDouble(6);
            Double density = resultSet.getDouble(7);
            arrayList.add(new Material(id ,name, type, coefficientA, coefficientB, coefficientC, density));
        }
        System.out.println(arrayList);
        statement.close();
    }

    @Test
    void update() throws SQLException {
        Material material = new Material(4,"TestIntellijV2.0", "TypeTest" , 1.31, 1.13, 13.1 ,1.1);
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, material.getName());
        preparedStatement.setString(2, material.getType());
        preparedStatement.setString(3, String.valueOf(material.getCoefficientA()));
        preparedStatement.setString(4, String.valueOf(material.getCoefficientB()));
        preparedStatement.setString(5, String.valueOf(material.getCoefficientC()));
        preparedStatement.setString(6, String.valueOf(material.getDensity()));
        preparedStatement.setString(7, String.valueOf(material.getId()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Test
    void delete() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        Material material = new Material(4,"TestIntellijV2.0", "TypeTest" , 1.31, 1.13, 13.1 ,1.1);
        preparedStatement.setString(1, String.valueOf(material.getId()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Test
    void selectAllNames() throws SQLException {
        List<String> strings = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_BY_NAME);
        while (resultSet.next()){
            strings.add(resultSet.getString("name"));
        }
        System.out.println(strings);
        statement.close();
    }
}