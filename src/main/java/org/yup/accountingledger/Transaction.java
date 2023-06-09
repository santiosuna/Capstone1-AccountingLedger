package org.yup.accountingledger;
import java.time.LocalDate;
import java.time.LocalTime;
public class Transaction {
    private LocalDate today;
    private LocalTime currentTime;
    private String description;
    private String vendor;
    private double amount;
    private boolean isDebit;

    public Transaction(LocalDate today, LocalTime currentTime, String description, String vendor, double amount, boolean isDebit) {
        this.today = today;
        this.currentTime = currentTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.isDebit = isDebit;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }
}