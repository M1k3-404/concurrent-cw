/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

public interface iServiceTicketMachine extends iTicketMachine{
    int PAPER_REFILL_CAPACITY = 5;
    int TONER_REFILL_CAPACITY = 4;

    void refillPaper();

    void replaceToner();
}
