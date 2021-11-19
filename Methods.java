import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import Checker.Checker;

public class Methods {
    public String url = "jdbc:postgresql://localhost:5432/Online_shop_management";
    public String user = "postgres";
    public String password = "dbhec123";
    Scanner scan = new Scanner(System.in);

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void Login_Cusstomer() throws SQLException {
        try (Connection conn = connect()) {
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select id, name, email, password from customer where email=? and password=?"); // verification
            System.out.println("Write your email:");
            String log = scan.nextLine();
            System.out.println("Enter your password:");
            String passw = scan.nextLine();
            st.setString(1, log);
            st.setString(2, passw);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { // if the data match, then the application works on
                System.out.println("You have successfully logged in Customer: " + rs.getString("name"));
                System.out.println("Settings");
                int ch = scan.nextInt();
                switch (ch) {
                case 1:
                    checkNotify(rs.getInt("id"));
                case 2:
                    System.out.println("settings");
                case 3:
                    System.out.println("check shop collection");
                case 4:
                    System.out.println("check cart");
                default:
                    System.out.println("ERROR");
                }
            } else {
                System.out.println("Wrong Username & Password");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void add_Customer() throws SQLException { // method that add new users into database
        try (Connection connection = connect()) {
            String sql = "insert into customer (name,email,phone,password) " + // inserting in sql
                    "VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Write your name:");
            statement.setString(1, scan.nextLine()); // adding username in 1 column
            System.out.println("Write your email:");
            statement.setString(2, scan.nextLine()); // adding email in 2 column
            System.out.println(
                    "Password must to contain at least 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special symbol(@,$,!,^) and length more or equal to 8.");
            System.out.println("Write your password:");
            String pq = scan.nextLine();
            statement.setString(4, pq); // adding password in 3 column
            Checker check = new Checker();
            System.out.println("Write your phone number:");
            statement.setString(3, scan.nextLine());
            if (check.checkerPassoword(pq)) { // check password with checker
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) { // checking data additions to the database
                    System.out.println("You have successfully registered !!!");
                }
            } else {
                System.exit(1);
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void checkNotify(int ids) {
        try (Connection connection = connect()) {
            String sql = "select notification, is_sub from customer where id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ids);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("is_sub"))
                    System.out.println("Notification: " + rs.getString("notification"));
                else
                    System.out.println("You have not subscribe");
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
