package controllers.main.pageOne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Layer;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewLayer implements Initializable {

    private Layer layer;
    private Material material;

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


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    @FXML
    void addNewMaterial(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/selectNewMaterial.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("База данных");
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) lambdaTextField.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        layerThicknessTextField.setText("0");
        lambdaTextField.setText("0");

        nameOfLayerTextField.setText(material.getName());
        coefficientATextField.setText(String.valueOf(material.getCoefficientA()));
        coefficientBTextField.setText(String.valueOf(material.getCoefficientB()));
        coefficientCTextField.setText(String.valueOf(material.getCoefficientC()));

    }
}


