/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

public class TravelDetails {
    private final String DepartureLocation;

    private final String ArrivalLocation;

    public TravelDetails(String DepartureLocation, String ArrivalLocation) {
        this.DepartureLocation = DepartureLocation;
        this.ArrivalLocation = ArrivalLocation;
    }

    public String getDepartureLocation() {
        return DepartureLocation;
    }

    public String getArrivalLocation() {
        return ArrivalLocation;
    }

    @Override
    public String toString() {
        return "TravelDetails [" +
                "DepartureLocation : " + DepartureLocation +
                ", ArrivalLocation : " + ArrivalLocation +
                "]";
    }
}
