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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Material;
import models.ObjectName;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable{

    public static Material objectToNextScene = new Material();

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button closeButton;

    @FXML
    private TableView<ObjectName> tableView;

    @FXML
    private TableColumn<ObjectName, String> tableViewColumn;

    public DatabaseController() throws SQLException {
    }

    @FXML
    void addButton(ActionEvent event) throws IOException {
        nextStage("/view/databaseAdd.fxml");
    }

    @FXML
    void changeButton(ActionEvent event) throws IOException, SQLException {

        ObjectName objectName = tableView.getSelectionModel().getSelectedItem();

        if(objectName == null){
            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для изменения не выбран");
        } else {
            objectToNextScene = MainDAOController.getObjectByName(objectName);
            nextStage("/view/databaseEdit.fxml");
        }
    }

    @FXML
    void closeButton(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void removeButton(ActionEvent event) throws IOException, SQLException {

        ObjectName objectName = tableView.getSelectionModel().getSelectedItem();

        if (objectName == null){
            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для удаления не выбран");
        } else {
            MainDAOController.removeSelectedObject(objectName.getName());
            tableView.refresh();
            refreshScene();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableView.setItems(objectNames);
    }

    private ObservableList<ObjectName> objectNames = FXCollections.observableArrayList(MainDAOController.convertNameToObservable());

    private void nextStage(String sceneURL) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(sceneURL));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void refreshScene() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/databaseDefault.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        Stage stage1 = (Stage) addButton.getScene().getWindow();
        stage1.close();
    }
}

