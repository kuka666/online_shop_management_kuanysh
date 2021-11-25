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
            Scanner scan = new Scanner(System.in);
            System.out.println("Write your email:");
            String log = scan.nextLine();
            System.out.println("Enter your password:");
            String passw = scan.nextLine();
            st.setString(1, log);
            st.setString(2, passw);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { // if the data match, then the application works on
                System.out.println("You have successfully logged in Customer: " + rs.getString("name"));
            } else {
                System.out.println("Wrong Username & Password");
                System.exit(1);
            }
            System.out.println("Choose the number 1-5:");
            System.out.println("1-Check Notify");
            System.out.println("2-Change the settings");
            System.out.println("3-check shop collection");
            System.out.println("4-Check cart");
            System.out.println("5-Exit");
            int ch = scan.nextInt();
            switch (ch) {
            case 1:
                checkNotify(rs.getInt("id"));
                break;
            case 2:
                System.out.println("settings");
                settings(log, passw);
                break;
            case 3:
                System.out.println("check shop collection");
                // shop_collection
                break;
            case 4:
                System.out.println("check cart");
                break;
            default:
                System.exit(1);
                break;
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void check_shop_collection() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "select item_id,type,description,price from item";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("item_id") + " " + rs.getString("type") + " Price: "
                        + rs.getFloat("price") + "$ Description: " + rs.getString("description"));
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // public void add_to_cart() throws SQLException{
    // try(Connection connection=connect()){
    // String sql = "select*from cart where customer_id=?";
    // PreparedStatement statement = connection.prepareStatement(sql);
    // statement.setInt(1, ids);
    // ResultSet rs = statement.executeQuery();
    // if (rs.next()) {
    // if (rs.getBoolean("is_sub"))
    // System.out.println("Notification: " + rs.getString("notification"));
    // else
    // System.out.println("You have not subscribe");
    // }

    // if()
    // }catch(SQLException ex){
    // ex.printStackTrace();
    // }
    // }

    public void add_Customer() throws SQLException { // method that add new users into database
        try (Connection connection = connect()) {
            String sql = "insert into customer (name,email,phone,password) " + // inserting in sql
                    "VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Write your name:");
            statement.setString(1, scan.nextLine()); // adding username in 1 column
            System.out.println("Write your email:");
            String email = scan.nextLine();
            statement.setString(2, email); // adding email in 2 column
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
            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("select*from customer where email=? and password=? "); // verification
            st.setString(1, email);
            st.setString(2, pq);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { // if the data match, then the application works on
                String sql2 = "insert into cart (customer_id) " + "VALUES (?)";
                PreparedStatement statement1 = connection.prepareStatement(sql2);
                statement1.setInt(1, rs.getInt("id"));
                statement1.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        public void check_cart(int id) {
        try(Connection connection = connect()) {
            String sql = "select * from cart where customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("type")
                        + " Price: " + rs.getFloat("price") + " Description: " + rs.getString("desc"));
            }
            System.out.println("Choose action(1-4):");
            System.out.println("Make purchase");
            System.out.println("Add product");
            System.out.println("Remove product");
            System.out.println("Exit");
            int ch = scan.nextInt();
            switch (ch){
                case 1:
                    purchase(id);
                    break;
                case 2:
                    //add
                    break;
                case 3:
                    //remove
                    break;
                default:
                    System.exit(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void purchase(int id){
        try(Connection connection = connect()) {
            String sql = "select sum(price) as total from cart where customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                System.out.println("Total price: " + rs.getFloat("total"));
            System.out.println("(1)buy\n(2)cancel:");
            int ch = scan.nextInt();
            switch (ch){
                case 1:
                    String sql1 = "delete from cart where customer_id = ?";
                    statement = connection.prepareStatement(sql1);
                    statement.setInt(1, id);
                    int rs1 = statement.executeUpdate();
                    String sql2 = "insert into cart (customer_id) values(?)";
                    statement = connection.prepareStatement(sql2);
                    statement.setInt(1, id);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) { // checking data additions to the database
                        System.out.print("Successful order!!!");
                    }
                    break;
                case 2:
                    check_cart(id);
                default:
                    System.exit(1);
            }
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

    public void settings(String log, String passw) throws SQLException {
        System.out.println("1-Change the password");
        System.out.println("2-Change the subscribtion notifictaion");
        System.out.println("3-Change the email");
        int a = scan.nextInt();
        if (a == 1) {
            change_pass(log, passw);
        } else if (a == 2) {
            change_subs(log, password);
        } else if (a == 3) {
            change_email(log, password);
        } else {
            System.out.println("ERROR");
        }
    }

    public void change_pass(String log, String pass) throws SQLException { // method change pass
        try (Connection connection = connect()) {
            Scanner scam = new Scanner(System.in);
            Checker check = new Checker();
            String sql = "UPDATE  customer set password=? where email=? and password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Enter a new password:");
            String passw = scam.nextLine();
            statement.setString(1, passw);
            statement.setString(2, log);
            statement.setString(3, pass);
            if (check.checkerPassoword(passw)) { // check password with checker
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) { // checking data additions to the database
                    System.out.println("You successfully update password");
                }
            } else {
                System.exit(1);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void change_subs(String log, String password) {
        try (Connection connection = connect()) {
            Scanner scam = new Scanner(System.in);
            String sql = "UPDATE  customer set is_sub=? where email=? and password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("1)Subscribe\n2)Unsubscribe");
            int sub_type = scam.nextInt();
            if (sub_type == 1)
                statement.setBoolean(1, true);
            else if (sub_type == 2)
                statement.setBoolean(1, false);
            else
                System.exit(1);
            statement.setString(2, log);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("You've successfully changed subscription mode!");
            else
                System.exit(1);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void change_email(String log, String password) {
        try (Connection connection = connect()) {
            Scanner scam = new Scanner(System.in);
            String sql = "UPDATE  customer set email=? where email=? and password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Enter a new email: ");
            String new_email = scam.nextLine();
            statement.setString(1, new_email);
            statement.setString(2, log);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("You've successfully changed email address!");
            else
                System.exit(1);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
