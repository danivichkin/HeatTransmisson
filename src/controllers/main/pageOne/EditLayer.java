package controllers.main.pageOne;

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

public class EditLayer implements Initializable {

    private Material material;
    private ObservableList<Layer> observableList;
    private Layer layer;

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
        observableList.remove(layer);
        //Костыль из за некоррекнтой работы FX
        SelectNewMaterial controller = loader.getController();
        Layer layer = new Layer(material,
                Double.valueOf(layerThicknessTextField.getText()),  Double.valueOf(lambdaTextField.getText()));
        controller.setObservableList(observableList);
        controller.setMaterial(material);
        controller.setLayer(layer);
        controller.setURL("/view/main/pageOne/EditLayer.fxml");

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
    void saveButton(ActionEvent event) throws IOException { ;
        Layer layer = new Layer();
        layer.setMaterial(material);
        layer.setLambda(Double.valueOf(lambdaTextField.getText()));
        layer.setLayerThickness(Double.valueOf(layerThicknessTextField.getText()));
        observableList.add(layer);

        Stage currentStage = (Stage) lambdaTextField.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setLayer(Layer layer) {
        nameOfLayerTextField.setText(layer.getMaterial().getName());
        coefficientATextField.setText(String.valueOf(layer.getMaterial().getCoefficientA()));
        coefficientBTextField.setText(String.valueOf(layer.getMaterial().getCoefficientB()));
        coefficientCTextField.setText(String.valueOf(layer.getMaterial().getCoefficientC()));
        layerThicknessTextField.setText(String.valueOf(layer.getLayerThickness()));
        lambdaTextField.setText(String.valueOf(layer.getLambda()));
        this.layer = layer;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setObservableList(ObservableList<Layer> observableList) {
        this.observableList = observableList;
    }
}
