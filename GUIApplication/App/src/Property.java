import java.io.Serializable;

public abstract class Property implements Serializable{
    private int lotNumber;
    private String address;
    private double landArea;

    public Property(int lotNumber, String address, double landArea) {
        this.lotNumber = lotNumber;
        this.address = address;
        this.landArea = landArea;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    @Override
    public String toString() {
        return "Lot Number: " + lotNumber + '\n' +
                "Address: " + address + '\n' +
                "Land Area: " + landArea + " sqm" + '\n';
    }
}
