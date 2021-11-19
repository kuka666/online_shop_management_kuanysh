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
                switch (s) {
                case 1:
                    System.out.println("1 - Log In\n" + "2 - Registration ");
                    a = scan.nextInt();
                    switch (a) {
                    case 1:
                        meth.Login_Cusstomer();
                    case 2:
                        meth.add_Customer();
                    default:
                        System.out.println("ERROR");
                    }
                    break;
                case 2:
                    // checkClothes
                    System.out.println("NEXT");
                default:
                    System.out.println("ERROR");
                }
            }

        }
    }
}
