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

    private final DAOController daoController = new DAOController();
    private ObservableList<Material> materials;
    private Material selectedMaterial;


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

    public EditController() throws SQLException {
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButton(ActionEvent event) throws SQLException {

        try {
            selectedMaterial.setName(nameTextField.getText());
            selectedMaterial.setType(typeChoice.getValue());
            selectedMaterial.setCoefficientA(Double.parseDouble(coefficientATextField.getText()));
            selectedMaterial.setCoefficientB(Double.parseDouble(coefficientBTextField.getText()));
            selectedMaterial.setCoefficientC(Double.parseDouble(coefficientCTextField.getText()));
            selectedMaterial.setDensity(Double.parseDouble(densityTextField.getText()));

            daoController.update(selectedMaterial);
            
            Material material = null; //Костыль для обновления объекта
            materials.add(material);  //Костыль для обновления объекта

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            AlertForDatabaseViews.defaultSuccess("", "Материал успешно изменён");
            materials.remove(material); //Костыль для обновления объекта

        } catch (Exception e) {
            AlertForDatabaseViews.defaultAlter("", "Некорректные значения");
        }
    }

    public void setMaterials(ObservableList<Material> materials) {
        this.materials = materials;
    }

    public void setSelectedMaterial(Material selectedMaterial) {
        nameTextField.setText(selectedMaterial.getName());
        typeChoice.setValue(selectedMaterial.getType());
        coefficientATextField.setText(String.valueOf(selectedMaterial.getCoefficientA()));
        coefficientBTextField.setText(String.valueOf(selectedMaterial.getCoefficientB()));
        coefficientCTextField.setText(String.valueOf(selectedMaterial.getCoefficientC()));
        densityTextField.setText(String.valueOf(selectedMaterial.getDensity()));
        this.selectedMaterial = selectedMaterial;

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> langs = FXCollections.observableArrayList("Огнеупор", "Теплоизоляционный", "Прочии материалы");
        typeChoice.setItems(langs);

    }


}
