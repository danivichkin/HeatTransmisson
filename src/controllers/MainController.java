package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class MainController {

    @FXML
    void changeDataBaseButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/databaseDefault.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("resources/icons/index1.png"));
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