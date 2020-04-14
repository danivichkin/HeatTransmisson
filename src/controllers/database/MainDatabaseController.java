package controllers.database;

import alerts.AlertForDatabaseViews;
import dao.DAOController;
import dao.DAOService;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainDatabaseController implements Initializable {

    //Объект для изменения в следующей сцене
    public static Material objectToNextScene = new Material();

    //TODO fix this shit
    DAOController daoController = new DAOController();
    DAOService daoService = new DAOService(daoController);

    @FXML
    private AnchorPane AnchPane;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tableViewColumnMaterial;

    @FXML
    private TableColumn<?, ?> tableViewColumnType;

    @FXML
    private TableColumn<?, ?> tableViewColumnCoefficientA;

    @FXML
    private TableColumn<?, ?> tableViewColumnCoefficientB;

    @FXML
    private TableColumn<?, ?> tableViewColumnCoefficientC;

    @FXML
    private TableColumn<?, ?> tableViewColumnDensity;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button closeButton;


    public MainDatabaseController() throws SQLException {
    }

    @FXML
    void addButton(ActionEvent event) throws IOException {
        nextStage("/view/database/Add.fxml");
    }

    @FXML
    void changeButton(ActionEvent event) throws IOException, SQLException {


//        if (objectName == null) {
//            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для изменения не выбран");
//        } else {
       //     objectToNextScene = DAOController.getObjectByName(objectName);
//            nextStage("/view/database/Edit.fxml");
//        }
    }

    @FXML
    void closeButton(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void removeButton(ActionEvent event) throws IOException, SQLException {


//        if (objectName == null) {
//            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для удаления не выбран");
//        } else {
       //     DAOController.removeSelectedObject(objectName.getName());
//            refreshScene();
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            ObservableList<String> materials = FXCollections.observableArrayList(daoService.getOnlyNamesAsObservableList());
            tableViewColumnMaterial.setCellValueFactory(new PropertyValueFactory<>("Name"));
            tableViewColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
            tableViewColumnCoefficientA.setCellValueFactory(new PropertyValueFactory<>("A"));
            tableViewColumnCoefficientB.setCellValueFactory(new PropertyValueFactory<>("B"));
            tableViewColumnCoefficientC.setCellValueFactory(new PropertyValueFactory<>("C"));
            tableViewColumnDensity.setCellValueFactory(new PropertyValueFactory<>("Density"));
          //  tableView.setItems();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private void nextStage(String sceneURL) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(sceneURL));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    private void refreshScene() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/database/DefaultScene.fxml"));
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        Stage stage1 = (Stage) addButton.getScene().getWindow();
        stage1.close();
    }
}

