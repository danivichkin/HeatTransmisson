package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

class DAOServiceTest {

    DAOController daoController = new DAOController();

    DAOServiceTest() throws SQLException {
    }

    @Test
    void getOnlyNamesAsObservableList() throws SQLException {
        ArrayList<String> arrayList = daoController.getAllNames();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(arrayList);
        System.out.println(observableList);
    }
}