package Decorator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllContent extends Bill {
    public int id;
    String desc;
    int price;
    int cost;
    public String url = "jdbc:postgresql://localhost:5432/Online_shop_management";
    public String user = "postgres";
    public String password = "dbhec123";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public AllContent(int ID) throws SQLException {
        id = ID;
        try (Connection conn = connect()) {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select*from cart where customer_id=?");
            st.setInt(1, ID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                desc = rs.getString("description");
            }
            description = desc;
        }
    }

    public int cost() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "select price from cart where customer_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cost = rs.getInt("price");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cost;

    }
}
