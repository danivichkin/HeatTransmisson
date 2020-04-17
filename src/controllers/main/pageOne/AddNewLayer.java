package controllers.main.pageOne;

import controllers.main.MainController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Layer;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewLayer implements Initializable {

    private Material material;
    private ObservableList<Layer> observableList;

    @FXML
    private AnchorPane Pane;

    @FXML
    private TextField nameOfLayerTextField;
    @FXML
    private TextField layerThicknessTextField;
    @FXML
    private TextField lambdaTextField;
    @FXML
    private TextField coefficientATextField;
    @FXML
    private TextField coefficientBTextField;
    @FXML
    private TextField coefficientCTextField;


    @FXML
    void addNewMaterial(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/selectNewMaterial.fxml"));
        Parent root = loader.load();

        //Костыль из за некоррекнтой работы FX
        SelectNewMaterial selectNewMaterial = loader.getController();
        selectNewMaterial.setObservableList(observableList);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("База данных");
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) lambdaTextField.getScene().getWindow(); //Костыль обновления тк сеттер работал некорректно
        currentStage.close();
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) lambdaTextField.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButton(ActionEvent event) throws IOException {
        Layer layer = new Layer();
        layer.setName(nameOfLayerTextField.getText());
        layer.setLambda(Double.valueOf(lambdaTextField.getText()));
        layer.setLayerThickness(Double.valueOf(layerThicknessTextField.getText()));
        observableList.add(layer);

        Stage currentStage = (Stage) lambdaTextField.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameOfLayerTextField.setText("#default");
        layerThicknessTextField.setText("0");
        lambdaTextField.setText("0");

    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        nameOfLayerTextField.setText(material.getName());
        coefficientATextField.setText(String.valueOf(material.getCoefficientA()));
        coefficientBTextField.setText(String.valueOf(material.getCoefficientB()));
        coefficientCTextField.setText(String.valueOf(material.getCoefficientC()));
        this.material = material;
    }

    public void setObservableList(ObservableList<Layer> observableList) {
        this.observableList = observableList;
    }
}


