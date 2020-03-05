package alerts;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertForDatabaseViews {

    public static void defaultAlter(String title, String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(context);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/icons/index1.png"));
        alert.getDialogPane().getScene().getWindow();
        alert.setAlertType(Alert.AlertType.ERROR );
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
