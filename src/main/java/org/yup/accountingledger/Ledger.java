package org.yup.accountingledger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ledger {
    public static void ledgerScreen() {
        boolean ledgerRuns = true;

        while (ledgerRuns) {

            Scanner userScanner = new Scanner(System.in);

            System.out.println("Now displaying Ledger Screen:");
            System.out.println("-------------------------------------------");
            System.out.println("Pleas make a selection:");
            System.out.println("- View all Entries (Enter A)");
            System.out.println("- View Deposits (Enter D)");
            System.out.println("- View Payments (Enter P)");
            System.out.println("- View Reports (Enter R)");
            System.out.println("- Return to Home Screen (Enter H)");
            System.out.println("-------------------------------------------");
            System.out.println("Enter your selection here:");

            String userInput = userScanner.nextLine();

            switch (userInput.toUpperCase()) {

                case "A" -> {

                    try {
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");

                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);

                        transactionsCsvReader.readLine();

                        String transactionLine;

                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {
                            System.out.println(transactionLine + "\n");
                        }

                        transactionsCsvReader.close();

                    } catch (IOException e) {
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                case "D" -> {

                    try {
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");

                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);

                        transactionsCsvReader.readLine();

                        String transactionLine;

                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {

                            String[] transactionDepositData = transactionLine.split("\\|");
                            transactionDepositData[4] = transactionDepositData[4].replace("$", "");
                            float transactionAmount = Float.parseFloat(transactionDepositData[4]);

                            if (transactionAmount > 0) {
                                System.out.println(transactionLine + "\n");
                            }
                        }
                        transactionsCsvReader.close();
                    } catch (IOException e) {
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                case "P" -> {
                    try {
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");

                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);

                        transactionsCsvReader.readLine();

                        String transactionLine;

                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {

                            String[] transactionPaymentData = transactionLine.split("\\|");
                            transactionPaymentData[4] = transactionPaymentData[4].replace("$", "");
                            float transactionAmount = Float.parseFloat(transactionPaymentData[4]);

                            if (transactionAmount < 0) {
                                System.out.println(transactionLine + "\n");
                            }
                        }
                        transactionsCsvReader.close();
                    } catch (IOException e) {
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                case "R" -> reportsScreen();

                case "H" -> {

                    System.out.println("Now returning to home screen...");

                    ledgerRuns = false;
                }

                default -> System.out.println("Error: Invalid choice, please try again.\n");
            }
        }
    }

    public static void reportsScreen() {

            Scanner userScanner = new Scanner(System.in);

            System.out.println("Now displaying Reports Screen:");
            System.out.println("-------------------------------------------");
            System.out.println("- View Month to Date (Enter 1)");
            System.out.println("- View Previous Month (Enter 2)");
            System.out.println("- View Year to Date (Enter 3)");
            System.out.println("- View Previous Year (Enter 4)");
            System.out.println("- Search by Vendor (Enter 5)");
            System.out.println("- Return to Ledger Screen (Enter 0)");
            System.out.println("-------------------------------------------");

            int reportsUserInput = Integer.parseInt(userScanner.nextLine());

            switch (reportsUserInput) {
                case 1 -> System.out.println("test");

                case 2 -> System.out.println("test2");

                case 3 -> System.out.println("test3");

                case 4 -> System.out.println("test4");

                case 5 -> System.out.println("test5");

                case 0 -> System.out.println("Now returning to ledger screen...\n");

                default -> System.out.println("Error: Invalid choice, please try again.\n");

            }
        }
    }




