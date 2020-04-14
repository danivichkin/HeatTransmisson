package dao;

import models.Material;

import java.sql.SQLException;
import java.util.List;

public interface MaterialDAO {
    void insert(Material material) throws SQLException;
    List<Material> select() throws SQLException;
    void update(Material material) throws SQLException;
    void delete(Material material) throws SQLException;

    List<String> getAllNames() throws SQLException;
}
