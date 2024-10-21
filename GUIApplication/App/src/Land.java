public class Land extends Property{
    public Land(int lotNumber, String address, double landArea) {
        super(lotNumber, address, landArea);
    }

    @Override
    public String toString() {
        return "[Land] " + super.toString();
    }
}
