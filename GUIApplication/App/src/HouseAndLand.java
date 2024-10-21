public class HouseAndLand extends Land {
    private double constructedArea;
    private int numBedrooms;
    private int numToilets;

    public HouseAndLand(int lotNumber, String address, double landArea,
            double constructedArea, int numBedrooms, int numToilets) {
        super(lotNumber, address, landArea);
        this.constructedArea = constructedArea;
        this.numBedrooms = numBedrooms;
        this.numToilets = numToilets;
    }

    public double getConstructedArea() {
        return constructedArea;
    }

    public void setConstructedArea(double constructedArea) {
        this.constructedArea = constructedArea;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumToilets() {
        return numToilets;
    }

    public void setNumToilets(int numToilets) {
        this.numToilets = numToilets;
    }

    @Override
    public String toString() {
        return "[House and Land] " + super.toString() + '\n' +
                "Constructed Area: " + constructedArea + " sqm" + '\n' +
                "Bedrooms: " + numBedrooms + '\n' +
                "Toilets: " + numToilets + '\n';
    }
}
