package controllers;

import dao.MainDAOController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Material;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseEditController implements Initializable{

    Material material = DatabaseController.objectToNextScene;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField plotnostTextField;

    @FXML
    private TextField bTextField;

    @FXML
    private TextField cTextField;

    @FXML
    private TextField aTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private ChoiceBox<String> typeChoise;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    void aTextField(ActionEvent event) {
    }

    @FXML
    void bTextField(ActionEvent event) {
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cTextField(ActionEvent event) {
    }

    @FXML
    void nameTextField(ActionEvent event) {
    }

    @FXML
    void plotnostTextField(ActionEvent event) {
    }

    @FXML
    void saveButton(ActionEvent event) throws SQLException {
        material.setName(nameTextField.getText());
        material.setB(Double.parseDouble(bTextField.getText()));
        material.setC(Double.parseDouble(cTextField.getText()));
        material.setPlotnost(Double.parseDouble(plotnostTextField.getText()));
        MainDAOController.removeSelectedObject(material.getName());
        MainDAOController.changeSelectedObject(material);
        material.setA(Double.parseDouble(aTextField.getText()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> langs = FXCollections.observableArrayList("Огнеупор", "Теплоизоляционный", "Прочии материалы");
        typeChoise.setItems(langs);
        typeChoise.setValue("Огнеупор");
        initTextFields();
    }

    private void initTextFields(){
        String type = choiceConvectorFromIntToString(material.getType());
        typeChoise.setValue(type);
        plotnostTextField.setText(String.valueOf(material.getPlotnost()));
        nameTextField.setText(material.getName());
        aTextField.setText(String.valueOf(material.getA()));
        bTextField.setText(String.valueOf(material.getB()));
        cTextField.setText(String.valueOf(material.getC()));
    }

    private String choiceConvectorFromIntToString(int value){
        String mat = "";
        switch (value) {
            case 1:
                return mat = "Огнеупор";
            case 2:
                return mat = "Теплоизоляционный";
            case 3:
                return mat = "Прочии материалы";
        }
        return mat;
    }
}
