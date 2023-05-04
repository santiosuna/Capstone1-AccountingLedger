package org.yup.accountingledger;
import java.util.Scanner;

public class Screens {
    public static String homeScreen() {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Hey Santiago, welcome to your account.");
        System.out.println("-------------------------------------------");
        System.out.println("Now displaying Home Screen:");
        System.out.println("- Add a Deposit (Enter D)");
        System.out.println("- Make a Payment (Enter P)");
        System.out.println("- Display the Ledger (Enter L)");
        System.out.println("- Exit App (Enter X)");
        System.out.println("-------------------------------------------");
        System.out.println("Enter your selection here:");

        return userInput.nextLine();

    }
}