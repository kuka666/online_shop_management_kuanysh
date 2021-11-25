package Decorator;

import java.sql.SQLException;

public class BrandedPackages extends FlavourDecorator {
    public BrandedPackages(Bill bill) {
        this.bill = bill;
    }

    public String getDescription() {
        return bill.getDescription() + ", with Branded Packages";
    }

    public int cost() throws SQLException {
        return bill.cost() + 15;
    }
}