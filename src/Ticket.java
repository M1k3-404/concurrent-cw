/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

import java.math.BigDecimal;

public class Ticket {
    private final int ticketId;

    private final BigDecimal ticketFare;

    private final PassengerDetails passengerDetails;

    private final TravelDetails travelDetails;

    public Ticket(int ticketId, BigDecimal ticketFare, PassengerDetails passengerDetails, TravelDetails travelDetails) {
        this.ticketId = ticketId;
        this.ticketFare = ticketFare;
        this.passengerDetails = passengerDetails;
        this.travelDetails = travelDetails;
    }

    public int getTicketId() {
        return ticketId;
    }

    public BigDecimal getTicketFare() {
        return ticketFare;
    }

    public PassengerDetails getPassengerDetails() {
        return passengerDetails;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    @Override
    public String toString() {
        return "Ticket [" +
                "ticketId : " + ticketId +
                ", ticketFare : " + ticketFare +
                ",\npassengerDetails : " + passengerDetails +
                ",\ntravelDetails : " + travelDetails +
                "]\n";
    }
}
