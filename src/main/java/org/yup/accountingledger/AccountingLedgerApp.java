package org.yup.accountingledger;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountingLedgerApp {
    public static void main(String[] args) {

        boolean appRuns = true;

        while (appRuns) {
            String homeScreenChoice = HomeScreen.displayHomeScreen();

                //user types a letter in home screen
                switch (homeScreenChoice.toUpperCase()) {

                case "D" ->
                    //prompts deposit
                    makeTransaction(true);
                case "P" ->
                    //prompts payment
                    makeTransaction(false);
                case "L" ->
                    //prompts ledger
                    Ledger.ledgerScreen();
                case "X" -> {
                    //prompts exit
                    appRuns = false;
                    System.out.println("Exiting app...Goodbye!");
                }
                default -> System.out.println("Error: Invalid choice, please try again.\n");
            }
        }
    }
    public static void makeTransaction(boolean isDebit) {

        Scanner userScanner = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.now();
        String formattedTime = time.format(formatter);

        System.out.println("Description: ");
        String description = userScanner.nextLine();

        System.out.println("Vendor: ");
        String vendor = userScanner.nextLine();

        System.out.println("Amount: ");
        double amount = userScanner.nextDouble();

            try {
            FileWriter writer = new FileWriter("transactions.csv", true);
            if (isDebit) {
                //writes input for deposit to file
                writer.append(String.format("%s | %s | %s | %s | %.2f\n", today, formattedTime, description, vendor, amount));
                System.out.println("Deposit added to file successfully.\n");
            } else {
                //writes input for payment to file
                writer.append(String.format("%s | %s | %s | %s | %.2f\n", today, formattedTime, description, vendor, amount * -1));
                System.out.println("Payment added to file successfully.\n");
            }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: Could not process data to file.");
        }
    }
}


