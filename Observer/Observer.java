package com.company.Observer;

import com.company.Checker;
import com.company.Methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Observer {
    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "1234";
    Scanner scan = new Scanner(System.in);

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public void Notify(String text){
        try (Connection connection = connect()) {
            String sql = "update customer set notification = ? where isSub = true";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, text);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
