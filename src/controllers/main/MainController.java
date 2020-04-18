package controllers.main;


import alerts.AlertsDefault;
import controllers.database.MainDatabaseController;
import controllers.main.pageOne.AddNewLayer;
import controllers.main.pageOne.EditLayer;
import dao.DAOController;
import dao.DAOService;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Layer;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final DAOController daoController = new DAOController();
    private final DAOService daoService = new DAOService(daoController);
    private final ObservableList<Material> observableListMainPage = daoService.getAllMaterials();

    private final ObservableList<Layer> layerObservableList = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> choiceBoxForTemp;

    @FXML
    private TextField square;

    @FXML
    private TextField temperature;

    @FXML
    private TextField degreeOfBlackness;

    @FXML
    private TextField tempInTheWorkSpace;

    @FXML
    private TextField returnСoefficient;

    @FXML
    private TableView<Layer> tableView;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<?, ?> tableColumnName;

    public MainController() throws SQLException {
    }

    @FXML
    void changeDataBaseButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/database/Main.fxml"));
        Parent root = loader.load();
        MainDatabaseController controller = loader.getController();
        controller.setMaterials(observableListMainPage);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("База данных");
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void compareButton(ActionEvent event) {

    }

    @FXML
    void addButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/addNewLayer.fxml"));
        Parent root = loader.load();
        AddNewLayer controller = loader.getController();
        controller.setObservableList(layerObservableList);
        controller.setLayer(new Layer());
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Добавления нового слоя");
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

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

    @FXML
    void deleteLayerButton(ActionEvent event) {

        Layer selectedLayer = tableView.getSelectionModel().getSelectedItem();

        if (selectedLayer == null) {
            AlertsDefault.defaultAlter("Ошибка", "Слой не выбран");
        } else {
            layerObservableList.remove(selectedLayer);
        }
    }

    @FXML
    void changeLayerButton(ActionEvent event) throws IOException {

        Layer selectedLayer = tableView.getSelectionModel().getSelectedItem();
        if (selectedLayer == null) {
            AlertsDefault.defaultAlter("Ошибка", "Материал не выбран");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/EditLayer.fxml"));
            Parent root = loader.load();
            EditLayer controller = loader.getController();
            controller.setObservableList(layerObservableList);
            controller.setLayer(selectedLayer);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Изменение слоя");
            stage.getIcons().add(new Image("resources/icons/index1.png"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //default values
        Material material = new Material("Name1", "type1", 1.0, 1.0, 1.0, 2.0);
        Material material2 = new Material("Name2", "type2", 21.0, 21.0, 21.0, 22.0);
        Material material3 = new Material("Name3", "type3", 31.0, 31.0, 31.0, 32.0);
        layerObservableList.add(new Layer(material, 1.1, 1.2));
        layerObservableList.add(new Layer(material2, 1.1, 1.2));
        layerObservableList.add(new Layer(material3, 1.1, 1.2));

        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Material"));
        tableView.setItems(layerObservableList);

        ObservableList<String> langs = FXCollections.observableArrayList("Вертикальная стенка", "Свод", "Под");
        choiceBoxForTemp.setItems(langs);
        choiceBoxForTemp.setValue("Вертикальная стенка");

        layerObservableList.addListener((InvalidationListener) change -> System.out.println("Changed detected"));

    }
}
