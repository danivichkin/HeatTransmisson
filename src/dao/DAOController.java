package dao;

import models.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOController implements MaterialDAO {

    private static final String url = "jdbc:sqlite:src/resources/database/mydatabase.sqlite";
    private static final String SELECT = "SELECT * FROM MATERIALS";
    private static final String DELETE = "DELETE FROM materials WHERE id=?";
    private static final String INSERT_MATERIAL = " Insert into materials (name, type, coefficientA," +
            " coefficientB, coefficientC, density) VALUES (?, ?, ?, ?, ?, ?) ";
    private static final String UPDATE = "UPDATE materials SET name=?, type=?, coefficientA=?," +
            " coefficientB=?, coefficientC=?, density=?  where id=?";
    private static final String SELECT_BY_NAME = "SELECT NAME FROM MATERIALS";
    private final Connection connection = DriverManager.getConnection(url);

    public DAOController() throws SQLException {
    }

    @Override
    public void insert(Material material) throws SQLException {
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

    @Override
    public List<Material> select() throws SQLException {
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
        statement.close();
        return arrayList;
    }

    @Override
    public void update(Material material) throws SQLException {
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

    @Override
    public void delete(Material material) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setString(1, String.valueOf(material.getId()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public ArrayList<String> getAllNames() throws SQLException {
        ArrayList<String> strings = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_BY_NAME);
        while (resultSet.next()) {
            strings.add(resultSet.getString("name"));
        }
        statement.close();
        return strings;
    }
}
