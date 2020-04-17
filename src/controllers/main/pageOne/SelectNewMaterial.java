package controllers.main.pageOne;

import alerts.AlertsDefault;
import controllers.database.AddController;
import dao.DAOController;
import dao.DAOService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

        if (selectedMaterial==null){
            AlertsDefault.defaultAlter("Ошибка","Материал не выбран");
        } else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main/pageOne/addNewLayer.fxml"));
            Parent root = loader.load();
            AddNewLayer controller = loader.getController();
            controller.setMaterial(selectedMaterial);
            Stage stage = (Stage) typeTextField.getScene().getWindow();
            stage.close();
            System.out.println(controller.getMaterial());
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
}
