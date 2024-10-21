import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static ArrayList<Person> buyers = new ArrayList<>();
    public static ArrayList<Person> sellers = new ArrayList<>();
    public static ArrayList<Property> properties = new ArrayList<>();
    public static ArrayList<Sale> sales = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream property = new FileInputStream("property.dat");
        FileInputStream seller = new FileInputStream("seller.dat");
        FileInputStream buyer = new FileInputStream("buyer.dat");
        FileInputStream sale = new FileInputStream("sale.dat");

        ObjectInputStream in1 = new ObjectInputStream(property);
        ObjectInputStream in2 = new ObjectInputStream(seller);
        ObjectInputStream in3 = new ObjectInputStream(buyer);
        ObjectInputStream in4 = new ObjectInputStream(sale);

        properties = (ArrayList<Property>) in1.readObject();
        sellers = (ArrayList<Person>) in2.readObject();
        buyers = (ArrayList<Person>) in3.readObject();
        sales = (ArrayList<Sale>) in4.readObject();

        in1.close();
        in2.close();
        in3.close();
        in4.close();
        

        launch(args);
    }
}