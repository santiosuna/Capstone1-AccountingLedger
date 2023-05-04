package org.yup.accountingledger;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountingLedgerApp {
    public static void main(String[] args) {

        boolean makesAppRun = true;

        while (makesAppRun) {
            String homeScreenChoice = homeScreen();

                //Allows user to type letter choice lower or upper case
                switch (homeScreenChoice.toUpperCase()) {

                //User types a letter in the homeScreen method based on the cases below
                case "D" ->
                    //prompts deposit in createsTransaction method
                    createsTransaction(true);
                case "P" ->
                    //prompts payment in createsTransaction method
                    createsTransaction(false);
                case "L" ->
                    //Ledger.java class and ledgerScreen method is called which prompts a new screen with options
                    Ledger.ledgerScreen();
                case "X" -> {
                    //prompts exit and closes the app
                    makesAppRun = false;
                    System.out.println("\n◢◤◢◤◢◤◢◤◢◤◢◤◢◤ Exiting App. Goodbye! ◢◤◢◤◢◤◢◤◢◤◢◤◢◤\n");
                }
                default -> System.out.println("\n⚠ Error: Invalid choice, please try again.\n");
            }
        }
    }

    public static String homeScreen() {

        Scanner userInput = new Scanner(System.in);

        //Main display when we run the app
        System.out.println("Hello Santiago, welcome to your account.");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("                ◩ HOME SCREEN ◪                 ");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("Pleas make a selection:");
        System.out.println("- Add a Deposit (Enter D)");
        System.out.println("- Add a Payment (Enter P)");
        System.out.println("- Display the Ledger (Enter L)");
        System.out.println("- Exit App (Enter X)");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("Enter your selection here:");

        return userInput.nextLine();
    }

    public static void createsTransaction(boolean isDebit) {

        Scanner userScanner = new Scanner(System.in);

        //Automatically saves current date and time, and formats it in the file
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.now();
        String formattedTime = time.format(formatter);

        //Prompts user with the input needed, and saves it
        System.out.println("Description of your transaction: ");
        String description = userScanner.nextLine();
        System.out.println("Vendor of your transaction: ");
        String vendor = userScanner.nextLine();
        System.out.println("Amount for your transaction: ");
        double amount = userScanner.nextDouble();

        //Uses saved input to write it to the file
            try {
            FileWriter writer = new FileWriter("transactions.csv", true);
            if (isDebit) {
                //writes and formats saved deposit to file
                writer.append(String.format("%s | %s | %s | %s | %.2f\n", today, formattedTime, description, vendor, amount));
                System.out.println("\n✓ Deposit added to file successfully.\n");
            } else {
                //writes and formats saved payment to file
                writer.append(String.format("%s | %s | %s | %s | %.2f\n", today, formattedTime, description, vendor, amount * -1));
                System.out.println("\n✓ Payment added to file successfully.\n");
            }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: Could not add data to file.");
        }
    }
}


