package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private ChoiceBox<String> choiceBox;

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
    private TableView<String> tableView;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<?, ?> tableColumn;

    @FXML
    void changeDataBaseButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/database/DefaultScene.fxml"));
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
    void addButton(ActionEvent event) {
        ObservableList<String> newList = FXCollections.observableArrayList("");
        newList.addAll(defaultList);
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

    //TODO принимать все объекты класса Material
    //TODO реализовать заполнение полей объектами 

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       // tableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
      //  tableView.setItems(defaultList);

        ObservableList<String> langs = FXCollections.observableArrayList("Вертикальная стенка", "Свод", "Под");
//        choiceBox.setItems(langs);
//        choiceBox.setValue("Вертикальная стенка");

    }

  //  private ObservableList<ObjectName> objectNames = FXCollections.observableArrayList(DAOController.convertNameToObservable());

    private ObservableList<String> defaultList = FXCollections.observableArrayList("");

}
