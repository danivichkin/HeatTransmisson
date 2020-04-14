package dao;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import models.Material;

import java.sql.SQLException;
import java.util.List;

public class DAOService {

    private final DAOController daoController;

    public DAOService(DAOController daoController) {
        this.daoController = daoController;
    }


    public ObservableList<Material> getAllMaterials() throws SQLException {

        //TODO верунть все объекты
        List<Material> materials = daoController.select();
        ObservableList<Material> materials1 = FXCollections.observableArrayList();
        return materials1;
    }

    public ObservableList<String> getOnlyNamesAsObservableList() throws SQLException {
        List<String> arrayList = daoController.getAllNames();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(arrayList);
        return observableList;
    }

}
