package Decorator;

import java.sql.SQLException;

public class Delivery extends FlavourDecorator {
    public Delivery(Bill bill) {
        this.bill = bill;
    }

    public String getDescription() {
        return bill.getDescription() + ", with Delivery";
    }

    public int cost() throws SQLException {
        return bill.cost() + 50;
    }
}
