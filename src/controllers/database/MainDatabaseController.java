package controllers.database;

import alerts.AlertForDatabaseViews;
import dao.DAOController;
import dao.DAOService;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    private DAOController daoController = new DAOController();

    private ObservableList<Material> materials;
    private Material selectedMaterial;

    @FXML
    private AnchorPane AnchPane;
    @FXML
    private TableView<Material> tableView;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/database/Add.fxml"));
        Parent root = loader.load();
        AddController controller = loader.getController();
        controller.setMaterials(materials);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Добавление нового материала");
        stage.getIcons().add(new Image("resources/icons/index1.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeButton(ActionEvent event) throws IOException, SQLException {

        selectedMaterial = tableView.getSelectionModel().getSelectedItem();

        if (selectedMaterial == null) {
            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для изменения не выбран");
        } else {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/database/Edit.fxml"));
            Parent root = loader.load();
            EditController controller = loader.getController();
            controller.setSelectedMaterial(selectedMaterial);
            controller.setMaterials(materials);
            Scene scene = new Scene(root);
            stage.setTitle("Изменение материала");
            stage.getIcons().add(new Image("resources/icons/index1.png"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void closeButton(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void removeButton(ActionEvent event) throws IOException, SQLException {

        selectedMaterial = tableView.getSelectionModel().getSelectedItem();

        if (selectedMaterial == null) {
            AlertForDatabaseViews.defaultAlter("Ошибка", "Материал для удаления не выбран");
        } else {
            materials.remove(selectedMaterial);
            daoController.delete(selectedMaterial);
            AlertForDatabaseViews.defaultSuccess("Удаление", "Материал удалён");
        }
    }


    public void setMaterials(ObservableList<Material> materials) {
        tableViewColumnMaterial.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableViewColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tableViewColumnCoefficientA.setCellValueFactory(new PropertyValueFactory<>("coefficientA"));
        tableViewColumnCoefficientB.setCellValueFactory(new PropertyValueFactory<>("coefficientB"));
        tableViewColumnCoefficientC.setCellValueFactory(new PropertyValueFactory<>("coefficientC"));
        tableViewColumnDensity.setCellValueFactory(new PropertyValueFactory<>("Density"));
        tableView.setItems(materials);
        this.materials = materials;

        materials.addListener(new ListChangeListener<Material>() {
            @Override
            public void onChanged(Change<? extends Material> change) {
                System.out.println("Changed detected");
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

