package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Material;

import java.sql.SQLException;
import java.util.List;

public class DAOService {

    private DAOController daoController;

    public DAOService(DAOController daoController) {
        this.daoController = daoController;
    }

    public ObservableList<Material> getAllMaterials() throws SQLException {
        List<Material> materialArrayList = daoController.select();
        ObservableList<Material> observableList = FXCollections.observableArrayList();
        observableList.addAll(materialArrayList);
        return observableList;
    }

    public ObservableList<String> getOnlyNamesAsObservableList() throws SQLException {
        List<String> arrayList = daoController.getAllNames();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(arrayList);
        return observableList;
    }

}
