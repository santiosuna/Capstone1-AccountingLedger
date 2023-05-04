package org.yup.accountingledger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ledger {
    public static void ledgerScreen() {
        boolean makesLedgerRun = true;

        //The ledgerScreen method runs a loop that displays options to user
        while (makesLedgerRun) {

            Scanner userScanner = new Scanner(System.in);

            System.out.println("════════════════════════════════════════════════");
            System.out.println("               ◩ LEDGER SCREEN ◪                ");
            System.out.println("════════════════════════════════════════════════");
            System.out.println("Pleas make a selection:");
            System.out.println("- View all Entries (Enter A)");
            System.out.println("- View Deposits (Enter D)");
            System.out.println("- View Payments (Enter P)");
            System.out.println("- View Reports Screen (Enter R)");
            System.out.println("- Return to Home Screen (Enter H)");
            System.out.println("════════════════════════════════════════════════");
            System.out.println("Enter your selection here:");

            String userInput = userScanner.nextLine();

            //Reads the user's input and performs an action based on the selection
            switch (userInput.toUpperCase()) {

                case "A" -> {
                    try {
                        //The file is read
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");
                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);
                        transactionsCsvReader.readLine();
                        String transactionLine;

                        //Formats and prints all the data in file to the user
                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {
                            System.out.println(transactionLine + "\n");
                        }
                        transactionsCsvReader.close();
                    }catch (IOException e){
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                case "D" -> {
                    try {
                        //The file is read
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");
                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);
                        transactionsCsvReader.readLine();
                        String transactionLine;

                        //Formats and prints only the deposit data we want from the file
                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {
                            String[] transactionDepositData = transactionLine.split("\\|");
                            transactionDepositData[4] = transactionDepositData[4].replace("$", "");
                            float transactionAmount = Float.parseFloat(transactionDepositData[4]);
                            if (transactionAmount > 0) {
                                System.out.println(transactionLine + "\n");
                            }
                        }
                        transactionsCsvReader.close();
                    }catch (IOException e){
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                case "P" -> {
                    try {
                        //The file is read
                        FileReader readTransactionsCsv = new FileReader("transactions.csv");
                        BufferedReader transactionsCsvReader = new BufferedReader(readTransactionsCsv);
                        transactionsCsvReader.readLine();
                        String transactionLine;

                        //Formats and prints only the payment data we want from the file
                        while ((transactionLine = transactionsCsvReader.readLine()) != null) {
                            String[] transactionPaymentData = transactionLine.split("\\|");
                            transactionPaymentData[4] = transactionPaymentData[4].replace("$", "");
                            float transactionAmount = Float.parseFloat(transactionPaymentData[4]);
                            if (transactionAmount < 0) {
                                System.out.println(transactionLine + "\n");
                            }
                        }
                        transactionsCsvReader.close();
                    }catch (IOException e) {
                        System.out.println("Error: Could not read the file." + e.getMessage());
                    }
                }

                //reportsScreen method is called which displays the reports screen options
                case "R" -> reportsScreen();

                case "H" -> {

                    System.out.println("\n◢◤◢◤◢◤◢◤◢◤◢◤◢◤ Returning to Home screen ◢◤◢◤◢◤◢◤◢◤◢◤◢◤\n");

                    makesLedgerRun = false;
                }
                default -> System.out.println("\n⚠ Error: Invalid choice, please try again.\n");
            }
        }
    }
    public static void reportsScreen() {

        Scanner userScanner = new Scanner(System.in);

        System.out.println("════════════════════════════════════════════════");
        System.out.println("              ◩ REPORTS SCREEN ◪                ");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("- View Month to Date (Enter 1)");
        System.out.println("- View Previous Month (Enter 2)");
        System.out.println("- View Year to Date (Enter 3)");
        System.out.println("- View Previous Year (Enter 4)");
        System.out.println("- Search by Vendor (Enter 5)");
        System.out.println("- Return to Ledger Screen (Enter 0)");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("Enter your selection here:");

        int reportsUserInput = Integer.parseInt(userScanner.nextLine());

        switch (reportsUserInput) {
            case 1 -> reportsMonthToDate();

            case 2 -> reportsPreviousMonth();

            case 3 -> reportsYearToDate();

            case 4 -> reportsPreviousYear();

            case 5 -> reportsSearchByVendor();

            case 0 -> System.out.println("◢◤◢◤◢◤◢◤◢◤◢◤◢◤ Returning to Ledger Screen ◢◤◢◤◢◤◢◤◢◤◢◤◢◤\n");

            default -> System.out.println("\n⚠ Error: Invalid choice, please try again.\n");
        }
    }
    private static void reportsMonthToDate() {

        System.out.println("Displaying Month to Date Report:");
    }
    private static void reportsPreviousMonth() {

    }
    private static void reportsYearToDate() {

    }
    private static void reportsPreviousYear() {

    }
    private static void reportsSearchByVendor() {

        Scanner userScanner = new Scanner(System.in);

        System.out.println("\nEnter vendor name:");
        String vendorName = userScanner.nextLine();

    }
}




