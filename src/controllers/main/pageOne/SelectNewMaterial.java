package controllers.main.pageOne;

import alerts.AlertsDefault;
import dao.DAOController;
import dao.DAOService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Layer;
import models.Material;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SelectNewMaterial implements Initializable {

    private final DAOController daoController = new DAOController();
    private final DAOService daoService = new DAOService(daoController);
    private final ObservableList<Material> observableListOfMaterials = daoService.getAllMaterials();
    private Material selectedMaterial;
    private Layer layer;
    private Material material;
    private String URL;

    private ObservableList<Layer> observableList; //Костыль из за некоррекнтой работы FX


    @FXML
    private TextField nameOfMaterialTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField coefficientBTextField;

    @FXML
    private TextField coefficientATextField;

    @FXML
    private TextField coefficientCTextField;

    @FXML
    private TextField densityTextField;

    @FXML
    private TableColumn<?, ?> nameTableColumn;

    @FXML
    private TableColumn<?, ?> typeTableColumn;

    @FXML
    private TableColumn<?, ?> densityTableColumn;

    @FXML
    private TableView<Material> tableView;

    public SelectNewMaterial() throws SQLException {
    }

    @FXML
    void acceptButton(ActionEvent event) throws IOException {

        selectedMaterial = tableView.getSelectionModel().getSelectedItem();

        if (selectedMaterial == null) {
            AlertsDefault.defaultAlter("Ошибка", "Материал не выбран");
        } else {

            //Костыль обновления тк сеттер работал некорректно
            Stage stage = (Stage) typeTextField.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(URL));
            Stage newStage = new Stage();
            Parent root = loader.load();
            Scene scene = new Scene(root);

            switch (URL){
                case ("/view/main/pageOne/EditLayer.fxml"):

                    observableList.remove(layer);
                    Layer layer1 = new Layer(selectedMaterial, layer.getLayerThickness(), layer.getLambda());

                    EditLayer controller = loader.getController();
                    controller.setMaterial(selectedMaterial);
                    controller.setObservableList(observableList);
                    controller.setLayer(layer1);
                    newStage.setTitle("Изменение слоя");
                    break;
                case ("/view/main/pageOne/addNewLayer.fxml"):
                    AddNewLayer controller1 = loader.getController();
                    controller1.setMaterial(selectedMaterial);
                    controller1.setObservableList(observableList);
                    controller1.setLayer(layer);
                    newStage.setTitle("Добавление слоя");
                    break;
            }

            newStage.setScene(scene);
            newStage.getIcons().add(new Image("resources/icons/index1.png"));
            newStage.setResizable(false);
            newStage.show();
        }

    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) typeTextField.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        densityTableColumn.setCellValueFactory(new PropertyValueFactory<>("Density"));
        tableView.setItems(observableListOfMaterials);

        tableView.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            selectedMaterial = tableView.getSelectionModel().getSelectedItem();

            nameOfMaterialTextField.setText(selectedMaterial.getName());
            typeTextField.setText(selectedMaterial.getType());
            coefficientATextField.setText(String.valueOf(selectedMaterial.getCoefficientA()));
            coefficientBTextField.setText(String.valueOf(selectedMaterial.getCoefficientB()));
            coefficientCTextField.setText(String.valueOf(selectedMaterial.getCoefficientC()));
            densityTextField.setText(String.valueOf(selectedMaterial.getDensity()));

        });
    }

    public void setObservableList(ObservableList<Layer> observableList) {
        this.observableList = observableList;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public void setURL(String URL) { this.URL = URL; }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
