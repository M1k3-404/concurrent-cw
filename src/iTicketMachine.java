/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

public interface iTicketMachine {
    int PAPER_CAPACITY = 10;
    int TONER_CAPACITY = 8;

    void printTicket(Ticket ticket);

    int getPaperLevel();

    int getTonerLevel();
}
