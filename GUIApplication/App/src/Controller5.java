import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller5 {

    @FXML
    private Button add;

    @FXML
    private TextField buyer;

    @FXML
    private TextField lotNo;

    @FXML
    private TextField price;

    @FXML
    private TextField saleID;

    @FXML
    private TextField seller;

    @FXML
    void addRecord(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);

        if (this.saleID.getText().isEmpty()) {
            alert.setContentText("sale id field is empty");
            alert.show();
            return;
        }
        if (this.seller.getText().isEmpty()) {
            alert.setContentText("seller field is empty");
            alert.show();
            return;
        }
        if (this.buyer.getText().isEmpty()) {
            alert.setContentText("buyer field is empty");
            alert.show();
            return;
        }
        if (this.price.getText().isEmpty()) {
            alert.setContentText("price field is empty");
            alert.show();
            return;
        }
        if (this.lotNo.getText().isEmpty()) {
            alert.setContentText("lot number field is empty");
            alert.show();
            return;
        }

        try {
            int lotNo = Integer.parseInt(this.lotNo.getText());
            int saleID = Integer.parseInt(this.saleID.getText());
            float price = Float.parseFloat(this.price.getText());
            String seller = this.seller.getText();
            String buyer = this.buyer.getText();
            Seller sellerObj = null;
            Buyer buyerObj = null;
            Property propertyObj = null;

            // find seller by name
            for (Person s : App.sellers) {
                if (s.getName().toLowerCase().equals(seller.toLowerCase())) {
                    sellerObj = (Seller) s;
                    break;
                }
            }
            // find buyer by name
            for (Person b : App.buyers) {
                if (b.getName().toLowerCase().equals(buyer.toLowerCase())) {
                    buyerObj = (Buyer) b;
                    break;
                }
            }

            // find property by lot number
            for (Property p : App.properties) {
                if (p.getLotNumber() == lotNo) {
                    propertyObj = p;
                    break;
                }
            }

            if (sellerObj == null) {
                alert.setContentText("Error: Invalid seller name");
                alert.show();
                return;

            }
            if (buyerObj == null) {
                alert.setContentText("Error: Invalid buyer name");
                alert.show();
                return;

            }
            if (propertyObj == null) {
                alert.setContentText("Error: Invalid property lot number");
                alert.show();
                return;

            }

            App.sales.add(new Sale(saleID, new Date(), price, propertyObj, sellerObj, buyerObj));
            alert.setContentText("Successful");
            alert.setAlertType(AlertType.INFORMATION);
            alert.show();
        } catch (NumberFormatException e) {
            alert.setContentText("Error: Invalid data entered!");
            alert.show();
        }
    }

}
