package Decorator;

import java.sql.SQLException;

public class Bill {

    String description = "";

    public String getDescription() {
        return description;
    }

    public int cost() throws SQLException {
        return 0;
    }

}
