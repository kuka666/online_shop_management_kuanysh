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
import Observer.Observer;
import Strategy.CreditCard;
import Strategy.PayPal;
import Strategy.Payment;

public class FactoryMethods {
    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "1234";
    Scanner scan = new Scanner(System.in);
    int cost;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addJeansBlackM() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'M size, Black')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blackMjeans = factoryjeans.getType("BlackMJeans");
                System.out.println(blackMjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlackL() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'L size, Black')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blackLjeans = factoryjeans.getType("BlackLJeans");
                System.out.println(blackLjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlackS() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'S size, Black')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blackSjeans = factoryjeans.getType("BlackSJeans");
                System.out.println(blackSjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueM() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'M size, Blue')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blueMjeans = factoryjeans.getType("BlueMJeans");
                System.out.println(blueMjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueS() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'S size, Blue')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blueSjeans = factoryjeans.getType("BlueSJeans");
                System.out.println(blueSjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addJeansBlueL() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'Jeans', '20', 'L size, Blue')";
                FactoryMethodJeans factoryjeans = new FactoryMethodJeans();
                Jeans blueLjeans = factoryjeans.getType("BlueLJeans");
                System.out.println(blueLjeans.ChooseJeans());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackM() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'M size, Black')";
                FactoryMethod factory = new FactoryMethod();
                TShirts blackMshirt = factory.getType("BlackM");
                System.out.println(blackMshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackL() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'L size, Black')";
                FactoryMethod factory = new FactoryMethod();
                TShirts blackLshirt = factory.getType("BlackL");
                System.out.println(blackLshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtBlackS() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'S size, Black')";
                FactoryMethod factory = new FactoryMethod();
                TShirts blackSshirt = factory.getType("BlackS");
                System.out.println(blackSshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteM() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'M size, White')";
                FactoryMethod factory = new FactoryMethod();
                TShirts whiteMshirt = factory.getType("WhiteM");
                System.out.println(whiteMshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteL() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'L size, White')";
                FactoryMethod factory = new FactoryMethod();
                TShirts whiteLshirt = factory.getType("WhiteL");
                System.out.println(whiteLshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addTShirtWhiteS() throws SQLException {
        try (Connection connection = connect()) {
            String sql1 = "select max(item_id) as last from item";
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String sql = "insert into item (item_id,type,price,description) VALUES (?,'TShirt', '30', 'S size, White')";
                FactoryMethod factory = new FactoryMethod();
                TShirts whiteSshirt = factory.getType("WhiteS");
                System.out.println(whiteSshirt.ChooseTShirt());
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,rs.getInt("last")+1);
                statement.executeUpdate();
                connection.close();
            }
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
        Observer observer = new Observer();
        switch (items) {
        case 1:
            addJeansBlackM();
            observer.Notify("New Black Jeans");
            break;
        case 2:
            addJeansBlackL();
            observer.Notify("New Black Jeans");
            break;
        case 3:
            addJeansBlackS();
            observer.Notify("New Black Jeans");
            break;
        case 4:
            addJeansBlueM();
            observer.Notify("New Blue Jeans");
            break;
        case 5:
            addJeansBlueL();
            observer.Notify("New Blue Jeans");
            break;
        case 6:
            addJeansBlueS();
            observer.Notify("New Blue Jeans");
            break;
        case 7:
            addTShirtBlackM();
            observer.Notify("New Black T-Shirt");
            break;
        case 8:
            addTShirtBlackL();
            observer.Notify("New Black T-Shirt");
            break;
        case 9:
            addTShirtBlackS();
            observer.Notify("New Black T-Shirt");
            break;
        case 10:
            addTShirtWhiteM();
            observer.Notify("New White T-Shirt");
            break;
        case 11:
            addTShirtWhiteL();
            observer.Notify("New White T-Shirt");
            break;
        case 12:
            addTShirtWhiteS();
            observer.Notify("New White T-Shirt");
            break;
        default:
            System.out.println("");
            break;
        }
    }
}
