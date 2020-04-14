package controllers.database;

import alerts.AlertForDatabaseViews;
import dao.DAOController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Material;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    Material material = MainDatabaseController.objectToNextScene;

    @FXML
    private TextField densityTextField;

    @FXML
    private TextField coefficientBTextField;

    @FXML
    private TextField coefficientCTextField;

    @FXML
    private TextField coefficientATextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private ChoiceBox<String> typeChoice;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButton(ActionEvent event) throws SQLException {

        //TODO Переработать изменения объектов
        try {
            material.setName(nameTextField.getText());
            material.setType(typeChoice.getValue());
            material.setCoefficientA(Double.parseDouble(coefficientATextField.getText()));
            material.setCoefficientB(Double.parseDouble(coefficientBTextField.getText()));
            material.setCoefficientC(Double.parseDouble(coefficientCTextField.getText()));
            material.setDensity(Double.parseDouble(densityTextField.getText()));

          //  DAOController.removeSelectedObject(material.getName());
          //  DAOController.changeSelectedObject(material);

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            AlertForDatabaseViews.defaultSuccess("", "Материал изменён успешно");
        } catch (Exception e) {
            AlertForDatabaseViews.defaultAlter("", "Некорректные значения");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> langs = FXCollections.observableArrayList("Огнеупор", "Теплоизоляционный", "Прочии материалы");
        typeChoice.setItems(langs);

        typeChoice.setValue(material.getType());
        densityTextField.setText(String.valueOf(material.getDensity()));
        nameTextField.setText(material.getName());
        coefficientATextField.setText(String.valueOf(material.getCoefficientA()));
        coefficientBTextField.setText(String.valueOf(material.getCoefficientB()));
        coefficientCTextField.setText(String.valueOf(material.getCoefficientC()));

    }


    //TODO S
    private boolean isInputValid(TextField field) {
        if (field.getText() == null || (field.getText().length() == 0)) {
            AlertForDatabaseViews.defaultAlter("", "Не все поля заполнены");
            return false;
        } else return true;
    }

}
