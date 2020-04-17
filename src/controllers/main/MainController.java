package controllers.main;


import controllers.database.MainDatabaseController;
import controllers.main.pageOne.AddNewLayer;
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

    DAOController daoController = new DAOController();
    DAOService daoService = new DAOService(daoController);
    ObservableList<Material> observableListMainPage = daoService.getAllMaterials();


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
    private TableView<Material> tableView;

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
        Layer layer = new Layer();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/addNewLayer.fxml"));
        Parent root = loader.load();
        AddNewLayer controller = loader.getController();
        controller.setLayer(layer);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Material> defaultMaterialList = FXCollections.observableArrayList();

        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableView.setItems(observableListMainPage);

        ObservableList<String> langs = FXCollections.observableArrayList("Вертикальная стенка", "Свод", "Под");
        choiceBoxForTemp.setItems(langs);
        choiceBoxForTemp.setValue("Вертикальная стенка");




    }

}
