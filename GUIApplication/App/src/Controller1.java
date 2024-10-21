import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller1 {

    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private TextField area;

    @FXML
    private TextField lotNo;

    @FXML
    void addRecord(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR, "lot number is empty");
        if (this.lotNo.getText().isEmpty()) {
            alert.show();
            return;
        }
        if (this.address.getText().isEmpty()) {
            alert.setContentText("address field is empty");
            alert.show();
            return;
        }
        if (this.area.getText().isEmpty()) {
            alert.setContentText("area field is empty");
            alert.show();
            return;
        }

        try {
            int lotNo = Integer.parseInt(this.lotNo.getText());
            float area = Float.parseFloat(this.area.getText());
            String address = this.address.getText();
            App.properties.add(new Land(lotNo, address, area));
            alert.setContentText("Successful");
            alert.setAlertType(AlertType.INFORMATION);
            alert.show();
        } catch (NumberFormatException e) {
            alert.setContentText("Error: Invalid data entered!");
            alert.show();
        }
    }

}
