import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller3 {

    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private TextField name;

    @FXML
    void addRecord(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);

        if (this.address.getText().isEmpty()) {
            alert.setContentText("address field is empty");
            alert.show();
            return;
        }
        if (this.phone.getText().isEmpty()) {
            alert.setContentText("phone field is empty");
            alert.show();
            return;
        }
        if (this.name.getText().isEmpty()) {
            alert.setContentText("name field is empty");
            alert.show();
            return;
        }

        String name = this.name.getText();
        String address = this.address.getText();
        String phone = this.phone.getText();

        App.sellers.add(new Seller(name, address, phone));
        alert.setContentText("Successful");
        alert.setAlertType(AlertType.INFORMATION);
        alert.show();

    }

}
