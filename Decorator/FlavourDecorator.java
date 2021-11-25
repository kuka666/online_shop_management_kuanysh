package Decorator;

import java.sql.SQLException;

public abstract class FlavourDecorator extends Bill {
    public Bill bill;

    public abstract int cost() throws SQLException;
}