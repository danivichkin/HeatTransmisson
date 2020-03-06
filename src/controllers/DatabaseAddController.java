package controllers;

import alerts.AlertForDatabaseViews;
import dao.MainDAOController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseAddController implements Initializable {

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
        void saveButton(ActionEvent event) throws SQLException{
                material.setName(nameTextField.getText());
                material.setType(choiceConvectorFromStringToInt(typeChoise.getValue()));
                material.setA(Double.parseDouble(aTextField.getText()));
                material.setB(Double.parseDouble(bTextField.getText()));
                material.setC(Double.parseDouble(cTextField.getText()));
                material.setPlotnost(Double.parseDouble(plotnostTextField.getText()));
                MainDAOController.changeSelectedObject(material);
                Stage stage = (Stage) nameTextField.getScene().getWindow();
                stage.close();
                AlertForDatabaseViews.defaultSuccess("", "Материал добавлен успешно");
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                ObservableList<String> langs = FXCollections.observableArrayList("Огнеупор", "Теплоизоляционный", "Прочии материалы");
                typeChoise.setItems(langs);
                typeChoise.setValue("Огнеупор");
        }

        private int choiceConvectorFromStringToInt(String value){
                int mat = 0;
                switch (value) {
                        case "Огнеупор":
                                return mat = 1;
                        case "Теплоизоляционный":
                                return mat = 2;
                        case "Прочии материалы":
                                return mat = 3;
                }
                return mat;
        }


}
