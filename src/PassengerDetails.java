/*
Author: Muthula Alwis
Index: w1830178
Created: 27/12/2023
 */

public class PassengerDetails {
    private final String name;
    private final String contact;

    public PassengerDetails(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "PassengerDetails [" +
                "name : " + name +
                ", contact : " + contact +
                "]";
    }
}