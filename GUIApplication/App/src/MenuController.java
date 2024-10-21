import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane root;

    @FXML
    void open1(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("add_property.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open2(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("add_property_land_house.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open3(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("add_seller.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open4(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("add_buyer.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open5(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("add_sale.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open6(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("search.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openDashboard(ActionEvent event) {
        bp.getChildren().clear();
        try {
            bp.getChildren().add(FXMLLoader.load(getClass().getResource("dashboard.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {

        try {
            FileOutputStream property = new FileOutputStream("property.dat");
            FileOutputStream seller = new FileOutputStream("seller.dat");
            FileOutputStream buyer = new FileOutputStream("buyer.dat");
            FileOutputStream sale = new FileOutputStream("sale.dat");

            ObjectOutputStream out = new ObjectOutputStream(property);
            out.writeObject(App.properties);
            out.close();
            out = new ObjectOutputStream(seller);
            out.writeObject(App.sellers);
            out.close();
            out = new ObjectOutputStream(buyer);
            out.writeObject(App.buyers);
            out.close();
            out = new ObjectOutputStream(sale);
            out.writeObject(App.sales);
            out.close();

            Alert alert = new Alert(AlertType.INFORMATION,"Successful");
            alert.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
