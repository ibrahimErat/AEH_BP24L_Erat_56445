package pl.pp;

import java.util.Locale;

public class Account {
    // Private fields for encapsulation
    private String accountNumber;
    private double availableFunds;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;

    // Constructor
    public Account(String accountNumber, double initialFunds, String ownerName, String ownerEmail, String ownerPhone) {
        this.accountNumber = accountNumber;
        // Ensure initial funds are not negative
        this.availableFunds = Math.max(0, initialFunds); 
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        
        System.out.printf(Locale.US, "Account %s created for %s with initial balance PLN %.2f%n", 
                          accountNumber, ownerName, this.availableFunds);
    }

    // --- Getters ---
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAvailableFunds() {
        return availableFunds;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    // --- Setters ---
    // Account number usually doesn't change, but included for completeness
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    // Funds should only be changed via deposit/withdraw
    // public void setAvailableFunds(double availableFunds) { ... }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    
    // --- Operation Methods ---
    
    /**
     * Deposits a specified amount into the account.
     * @param amount The amount to deposit (must be positive).
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.availableFunds += amount;
            System.out.printf(Locale.US, "Deposit of PLN %.2f was made. New balance PLN %.2f%n", 
                              amount, this.availableFunds);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    /**
     * Withdraws a specified amount from the account if funds are sufficient.
     * @param amount The amount to withdraw (must be positive).
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        
        if (this.availableFunds >= amount) {
            this.availableFunds -= amount;
            System.out.printf(Locale.US, "Withdrew PLN %.2f from the account, Remaining balance = PLN %.2f%n", 
                              amount, this.availableFunds);
        } else {
            System.out.printf(Locale.US, "Insufficient funds. You have PLN %.2f in your account.%n", 
                              this.availableFunds);
        }
    }
} 