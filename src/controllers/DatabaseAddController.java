package controllers;

import dao.MainDAOController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Material;

import java.sql.SQLException;

public class DatabaseAddController {

        Material material = new Material();

        @FXML
        private AnchorPane Pane;

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
        private ChoiceBox<?> typeChoise;

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
                material.setA(Double.parseDouble(aTextField.getText()));
                material.setB(Double.parseDouble(bTextField.getText()));
                material.setC(Double.parseDouble(cTextField.getText()));
                material.setPlotnost(Double.parseDouble(plotnostTextField.getText()));
                MainDAOController.changeSelectedObject(material);
                Stage stage = (Stage) nameTextField.getScene().getWindow();
                stage.close();
        }


}
