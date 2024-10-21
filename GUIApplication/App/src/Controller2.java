import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller2 {

    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private TextField area;

    @FXML
    private TextField bedrooms;

    @FXML
    private TextField constructedArea;

    @FXML
    private TextField lotNo;

    @FXML
    private TextField toilets;

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

        if (this.constructedArea.getText().isEmpty()) {
            alert.setContentText("constructed area field is empty");
            alert.show();
            return;
        }

        if (this.bedrooms.getText().isEmpty()) {
            alert.setContentText("bedroom field is empty");
            alert.show();
            return;
        }

        if (this.toilets.getText().isEmpty()) {
            alert.setContentText("toilet field is empty");
            alert.show();
            return;
        }

        try {
            int lotNo = Integer.parseInt(this.lotNo.getText());
            int bedroom = Integer.parseInt(this.bedrooms.getText());
            int toilets = Integer.parseInt(this.toilets.getText());
            float area = Float.parseFloat(this.area.getText());
            float constructedArea = Float.parseFloat(this.constructedArea.getText());
            String address = this.address.getText();
            if (constructedArea > area) {
                alert.setContentText("Error: constructed area can't be bigger than land area");
                alert.show();
            } else {
                App.properties
                        .add(new HouseAndLand(lotNo, address, constructedArea, constructedArea, bedroom, toilets));
                alert.setContentText("Successful");
                alert.setAlertType(AlertType.INFORMATION);
                alert.show();
            }
        } catch (NumberFormatException e) {
            alert.setContentText("Error: Invalid data entered!");
            alert.show();
        }
    }

}
