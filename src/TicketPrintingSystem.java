/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

import java.math.BigDecimal;

public class TicketPrintingSystem {
    public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine(3, 3);

        PassengerDetails passengerDetails01 = new PassengerDetails("Maverick", "+94723456789");
        PassengerDetails passengerDetails02 = new PassengerDetails("Goose", "+94771824098");
        PassengerDetails passengerDetails03 = new PassengerDetails("Iceman", "+94733822687");
        PassengerDetails passengerDetails04 = new PassengerDetails("Rooster", "+94735183687");
        PassengerDetails passengerDetails05 = new PassengerDetails("Hangman", "+94745133657");

        TravelDetails tour01 = new TravelDetails("The Hard Deck bar", "Lemoore Naval Air Station");
        TravelDetails tour02 = new TravelDetails("Breakers Beach", "The Hard Deck bar");
        TravelDetails tour03 = new TravelDetails("Lemoore Naval Air Station", "Breakers Beach");

        Ticket ticket01 = new Ticket(001, new BigDecimal(1500), passengerDetails01, tour03);
        Ticket ticket02 = new Ticket(002, new BigDecimal(2000), passengerDetails02, tour01);
        Ticket ticket03 = new Ticket(003, new BigDecimal(2500), passengerDetails03, tour02);
        Ticket ticket04 = new Ticket(004, new BigDecimal(3000), passengerDetails04, tour03);
        Ticket ticket05 = new Ticket(005, new BigDecimal(1500), passengerDetails05, tour01);

        Passenger passenger01 = new Passenger(ticketMachine, ticket01);
        Passenger passenger02 = new Passenger(ticketMachine, ticket02);
        Passenger passenger03 = new Passenger(ticketMachine, ticket03);
        Passenger passenger04 = new Passenger(ticketMachine, ticket04);
        Passenger passenger05 = new Passenger(ticketMachine, ticket05);

        Thread passengerThread01 = new Thread(passenger01, "Maverick");
        Thread passengerThread02 = new Thread(passenger02, "Goose");
        Thread passengerThread03 = new Thread(passenger03, "Iceman");
        Thread passengerThread04 = new Thread(passenger04, "Rooster");
        Thread passengerThread05 = new Thread(passenger05, "Hangman");

        Thread paperTechnicianThread = new Thread(new TicketPaperTechnician(ticketMachine), "Paper Technician");
        Thread tonerTechnicianThread = new Thread(new TicketTonerTechnician(ticketMachine), "Toner Technician");

        paperTechnicianThread.start();
        tonerTechnicianThread.start();

        passengerThread01.start();
        passengerThread02.start();
        passengerThread03.start();
        passengerThread04.start();
        passengerThread05.start();
    }
}