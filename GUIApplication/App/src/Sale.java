import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale implements Serializable{
    private int saleId;
    private Date date;
    private double soldPrice;
    private Property property;
    private Seller seller;
    private Buyer buyer;

    public Sale(int saleId, Date date, double soldPrice, Property property, Seller seller, Buyer buyer) {
        this.saleId = saleId;
        this.date = date;
        this.soldPrice = soldPrice;
        this.property = property;
        this.seller = seller;
        this.buyer = buyer;
    }

    // Getter and setter methods
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getDate() {
        return new SimpleDateFormat("dd/mm/yyyy").format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}