/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

import java.util.Random;

public class TicketTonerTechnician implements Runnable {
    private final iServiceTicketMachine ticketMachine;

    Random random = new Random();

    public TicketTonerTechnician(iServiceTicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            if (ticketMachine.getTonerLevel() < 2) {
                ticketMachine.replaceToner();
            }


            try {
                Thread.sleep(random.nextInt(100) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
