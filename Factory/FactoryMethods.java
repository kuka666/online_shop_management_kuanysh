package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Checker.Checker;
import Decorator.AllContent;
import Decorator.Bill;
import Decorator.BrandedPackages;
import Decorator.Delivery;
import Strategy.CreditCard;
import Strategy.PayPal;
import Strategy.Payment;

public class FactoryMethods {
    public String url = "jdbc:postgresql://localhost:5432/Online_shop_management";
    public String user = "postgres";
    public String password = "dbhec123";
    Scanner scan = new Scanner(System.in);
    int cost;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addJeansBlackM() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'M size, Black')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blackMjeans = factoryjeans.getType("BlackMJeans");
            System.out.println(blackMjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlackL() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'L size, Black')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blackLjeans = factoryjeans.getType("BlackLJeans");
            System.out.println(blackLjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlackS() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'S size, Black')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blackSjeans = factoryjeans.getType("BlackSJeans");
            System.out.println(blackSjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueM() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'M size, Blue')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blueMjeans = factoryjeans.getType("BlueMJeans");
            System.out.println(blueMjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueS() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'S size, Blue')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blueSjeans = factoryjeans.getType("BlueSJeans");
            System.out.println(blueSjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueL() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('Jeans', '20', 'L size, Blue')";
            FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
            Jeans blueLjeans = factoryjeans.getType("BlueLJeans");
            System.out.println(blueLjeans.ChooseJeans());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackM() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'M size, Black')";
            FactoryMethod factory = new FactoryMethod();
            TShirts blackMshirt = factory.getType("BlackM");
            System.out.println(blackMshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackL() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'L size, Black')";
            FactoryMethod factory = new FactoryMethod();
            TShirts blackLshirt = factory.getType("BlackL");
            System.out.println(blackLshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackS() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'S size, Black')";
            FactoryMethod factory = new FactoryMethod();
            TShirts blackSshirt = factory.getType("BlackS");
            System.out.println(blackSshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteM() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'M size, White')";
            FactoryMethod factory = new FactoryMethod();
            TShirts whiteMshirt = factory.getType("WhiteM");
            System.out.println(whiteMshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteL() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'L size, White')";
            FactoryMethod factory = new FactoryMethod();
            TShirts whiteLshirt = factory.getType("WhiteL");
            System.out.println(whiteLshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteS() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "insert into item (type,price,description) VALUES ('T-Shirt', '10', 'S size, White')";
            FactoryMethod factory = new FactoryMethod();
            TShirts whiteSshirt = factory.getType("WhiteS");
            System.out.println(whiteSshirt.ChooseTShirt());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void factory_print() throws SQLException {
        System.out.println(
                "Choose item you want to add:\n 1 - Black Jeans with M size,\n 2 - Black Jeans with L size,\n 3 - Black Jeans with S size,"
                        + "\n 4 - Blue Jeans with M size,\n 5 - Blue Jeans with L size,\n 6 - Blue Jeans with S size,"
                        + "\n 7 - Black T-Shirt with M size, \n 8 - Black T-Shirt with L size,\n 9 - Black T-Shirt with S size,"
                        + "\n 10 - White T-Shirt with M size,\n 11 - White T-Shirt with L size,\n 12 - White T-Shirt with S size");
        int items = scan.nextInt();
        switch (items) {
        case 1:
            addJeansBlackM();
            break;
        case 2:
            addJeansBlackL();
            break;
        case 3:
            addJeansBlackS();
            break;
        case 4:
            addJeansBlueM();
            break;
        case 5:
            addJeansBlueL();
            break;
        case 6:
            addJeansBlueS();
            break;
        case 7:
            addTShirtBlackM();
            break;
        case 8:
            addTShirtBlackL();
            break;
        case 9:
            addTShirtBlackS();
            break;
        case 10:
            addTShirtWhiteM();
            break;
        case 11:
            addTShirtWhiteL();
            break;
        case 12:
            addTShirtWhiteS();
            break;
        default:
            System.out.println("");
            break;
        }
    }
}
