/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TicketMachine implements iServiceTicketMachine {

    private int paperLevel;
    private int tonerLevel;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition haveTonerLevel = lock.newCondition();
    private final Condition havePaperLevel = lock.newCondition();
    private final Condition noResource = lock.newCondition();

    public TicketMachine(int paperLevel, int tonerLevel) {
        this.paperLevel = paperLevel;
        this.tonerLevel = tonerLevel;
    }

    public int getPaperLevel() {
        return paperLevel;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    @Override
    public void printTicket(Ticket ticket) {
        try {
            lock.lock();

            // Checks if paper and toner levels are sufficient. [Reminder: If minimum paperLevel or tonerLevel is changed update the function in TicketPaperTechnician and TicketTonerTechnician accordingly.]
            while (!(paperLevel > 1 && tonerLevel > 1)) {
                System.out.println("No sufficient paper or toner available \n");
                noResource.await();
            }

            System.out.println("Printing ticket... \n" + ticket.toString());
            paperLevel -= 1;
            tonerLevel -= 1;

            System.out.println("Ticket printed for " + ticket.getPassengerDetails().getName() + "\n");
            havePaperLevel.signalAll();
            haveTonerLevel.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void refillPaper() {
        try {
            lock.lock();

            while ((paperLevel + PAPER_REFILL_CAPACITY) > PAPER_CAPACITY) {
                System.out.println("Machine has enough paper.");
                havePaperLevel.await();
            }

            paperLevel += PAPER_REFILL_CAPACITY;
            System.out.println("Paper refilled.\n");

            noResource.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void replaceToner() {
        try {
            lock.lock();

            while ((tonerLevel + TONER_REFILL_CAPACITY) > TONER_CAPACITY) {
                System.out.println("Machine has enough toner.");
                haveTonerLevel.await();
            }

            tonerLevel += TONER_REFILL_CAPACITY;
            System.out.println("Toner replaced.\n");

            noResource.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
