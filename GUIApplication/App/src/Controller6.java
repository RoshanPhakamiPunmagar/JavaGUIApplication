import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller6 implements Isearch {

    @FXML
    private Button btn;

    @FXML
    private TextField saleID;

    @FXML
    private TextArea textArea;

    @FXML
    void search(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);

        if (this.saleID.getText().isEmpty()) {
            alert.setContentText("search field is empty");
            alert.show();
            return;
        }
        try {
            int saleID = Integer.parseInt(this.saleID.getText());
            Sale sale = findSale(saleID);
            if (sale == null) {
                alert.setAlertType(AlertType.WARNING);
                alert.setContentText("No record found!");
                alert.show();
            }else{
                String data = "sale ID: " + sale.getSaleId() + "\n" +
                "Date: " + sale.getDate()  + "\n" +
                "Sold price: " + sale.getSoldPrice()  + "\n" +
                "_________________________________" + "\n" +
                "Property Info" + "\n" +
                "_________________________________" + "\n" +
                sale.getProperty() + "\n" +
                "_________________________________" + "\n" +
                "Seller Info" + "\n" +
                "_________________________________" + "\n" +
                sale.getSeller() + "\n" +
                "_________________________________" + "\n" +
                "Buyer Info" + "\n" +
                "_________________________________" + "\n" +
                sale.getBuyer();
                textArea.setText(data);
            }
            


            // textArea.setText("sale ID: " + sale.getSaleId());
        } catch (NumberFormatException e) {
            alert.setContentText("Error: Invalid data entered!");
            alert.show();
        }
    }

    @Override
    public Sale findSale(int id) {
        for (Sale sale : App.sales) {
            if (sale.getSaleId() == id) {
                return sale;
            }
        }
        return null;
    }

}
