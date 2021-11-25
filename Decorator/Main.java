package Decorator;

import java.sql.SQLException;

public class Main {

    static void printCoffee(Bill bill) throws SQLException {
        System.out.println("Order: " + bill.getDescription() + ". Cost: " + bill.cost());
    }

    public static void main(String args[]) throws Exception {
        Bill AllContent = new AllContent(5);
        Delivery cappwithMilk = new Delivery(AllContent);
        printCoffee(cappwithMilk);
        System.out.println("-------------------------");

        // BrandedPackages cappwithMilkandChoc = new BrandedPackages(cappwithMilk);
        // printCoffee(cappwithMilkandChoc);
        // System.out.println("-------------------------");

        // Delivery alless = new Delivery(new BrandedPackages(AllContent));
        // printCoffee(alless);
        // System.out.println("-------------------------");

    }
}
