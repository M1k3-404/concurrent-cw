/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

import java.util.Random;

public class Passenger implements Runnable {
    private iServiceTicketMachine ticketMachine;
    private final Ticket ticket;

    public Passenger(iServiceTicketMachine ticketMachine, Ticket ticket) {
        this.ticketMachine = ticketMachine;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        Random random = new Random();

            ticketMachine.printTicket(ticket);

            try {
                Thread.sleep(random.nextInt(100)+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
