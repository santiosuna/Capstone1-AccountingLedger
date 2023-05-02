package org.yup.accountingledger;
import java.util.Scanner;

public class Screens {
    public static String homeScreen() {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to your account ledger!\n");

        System.out.println("What would you like to do today:");
        System.out.println("-Add a Deposit (Enter D)");
        System.out.println("-Make a Payment (Enter P)");
        System.out.println("-Display the Ledger (Enter L)");
        System.out.println("-Exit App (Enter X)");

        System.out.println("\nEnter your selection here:");

        return userInput.nextLine();

    }
}