package org.yup.accountingledger;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class AccountingLedgerApp {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        boolean appRunning = true;

        while (appRunning) {

            String homeScreenChoice = Screens.homeScreen();

            switch (homeScreenChoice.toUpperCase()) {

                case "D":
                    LocalDate todaysDate = LocalDate.now();

                    LocalTime currentTime = LocalTime.now();

                    System.out.println("Description: ");
                    String descriptionInput = userInput.nextLine();

                    System.out.println("Vendor: ");
                    String vendorInput = userInput.nextLine();

                    System.out.println("Amount: ");
                    String amountInput = userInput.nextLine();

                    break;

                case "P":
                    todaysDate = LocalDate.now();

                    currentTime = LocalTime.now();

                    System.out.println("Description: ");
                    descriptionInput = userInput.nextLine();

                    System.out.println("Vendor: ");
                    vendorInput = userInput.nextLine();

                    System.out.println("Amount: ");
                    amountInput = userInput.nextLine();

                    break;

                case "L":

                    break;

                case "X":
                    appRunning = false;
                    System.out.println("Exiting app...Goodbye!");

                    break;

                default:
                    System.out.println("Invalid choice. Please try again!\n");
            }

        }
    }
}




