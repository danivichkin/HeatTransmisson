package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class Controller {

    @FXML
    void changeDataBaseButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/database.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void compareButton(ActionEvent event) {

    }

    @FXML
    void createFileButton(ActionEvent event) {

    }

    @FXML
    void openFileButton(ActionEvent event) {

    }

    @FXML
    void reportButton(ActionEvent event) {

    }

    @FXML
    void resultsButton(ActionEvent event) {

    }

    @FXML
    void saveFileButton(ActionEvent event) {

    }

    @FXML
    void settingsButton(ActionEvent event) {

    }

}