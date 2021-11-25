package Strategy;

import Checker.Checker;

import java.util.Scanner;

public class PayPal implements Pay{
    @Override
    public void pay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        System.out.println("Thank you for your order!!!");
    }
}
