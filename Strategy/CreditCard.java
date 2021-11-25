package Strategy;

import Checker.Checker;

import java.util.Scanner;

public class CreditCard implements Pay{
    private String cardNUm;
    private String cvv;
    private String data;
    @Override
    public void pay() {
        Scanner scan = new Scanner(System.in);
        Checker checker = new Checker();
        System.out.println("Enter your card num: ");
        cardNUm = scan.nextLine();
        checker.checkercardnumber(cardNUm);
        System.out.println("Enter your data(MM/yy): ");
        data = scan.nextLine();
        checker.checkercarddate(data);
        System.out.println("Enter your cvv num: ");
        cvv = scan.nextLine();
        checker.checkCVV(cvv);
        System.out.println("Thank you for your order!!!");
    }
}
