package alerts;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertsDefault {

    public static void defaultAlter(String title, String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(context);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/icons/index1.png"));
        ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        alert.setAlertType(Alert.AlertType.ERROR );
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void defaultSuccess(String title, String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(context);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/icons/index1.png"));
        ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        alert.getDialogPane().getScene().getWindow();
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
