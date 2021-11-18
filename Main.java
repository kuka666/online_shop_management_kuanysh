import java.sql.SQLException;
import java.util.Scanner;

public class Main { // the class that launches the application

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        Methods meth = new Methods();
        System.out.println("1 - Customer\n" + "2 - User ");
        int s = scan.nextInt();
        if (s == 1) {
            System.out.println("1 - Log In\n" + "2 - Registration ");
            int a = scan.nextInt();
            if (a == 1) {
                meth.Login_Cusstomer();
            } else if (a == 2) {
                meth.add_Customer();
            } else {
                System.out.println("ERROR");
            }
        } else if (s == 2) {
            System.out.println("NEXT");
        } else {
            System.out.println("ERROR");
        }

    }
}
