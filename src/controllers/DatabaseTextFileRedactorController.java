package controllers;

import DAO.MainDAOController;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DatabaseTextFileRedactorController implements Initializable{


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
    void saveButton(ActionEvent event) throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //ChoiceBox init
        ObservableList<String> langs = FXCollections.observableArrayList("Огнеупор", "Теплоизоляционный", "Прочии материалы");
        typeChoise.setItems(langs);
        typeChoise.setValue("Огнеупор");
    }
}

//TODO BD in text files with change current object
