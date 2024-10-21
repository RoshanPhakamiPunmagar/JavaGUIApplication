import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController implements Istatictics{

    @FXML
    private Label avg;

    @FXML
    private Label count;

    @FXML
    private Label max;

    @FXML
    private Label min;

    @FXML
    private Label profit;
    

    @FXML
    private void initialize() {

        count.setText(Integer.toString(App.sales.size()));
        profit.setText(Double.toString(total()));
        min.setText(Double.toString(minimum()));
        avg.setText(Double.toString(average()));
        max.setText(Double.toString(max()));
    }

    @Override
    public double minimum() {
        if (App.sales.size() == 0) {
            return 0;
        }
        double min = Double.MAX_VALUE;
        for (Sale sale : App.sales) {
            if (sale.getSoldPrice() < min){
                min = sale.getSoldPrice();
            }
        }
        return min;
    }

    @Override
    public double average() {
        if (App.sales.size() == 0) {
            return 0;
        }
        double total = 0;
        double records = App.sales.size();
        for (Sale sale : App.sales) {
            total += sale.getSoldPrice();
        }
        return total / records;
    }

    @Override
    public double max() {
        if (App.sales.size() == 0) {
            return 0;
        }
        double max = Double.MIN_VALUE;
        for (Sale sale : App.sales) {
            if (sale.getSoldPrice() > max){
                max = sale.getSoldPrice();
            }
        }
        return max;
    }

    @Override
    public double total() {
        double total = 0;
        for (Sale sale : App.sales) {
            total += sale.getSoldPrice();
        }
        return total;
    }

}
