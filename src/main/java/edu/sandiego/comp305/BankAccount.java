package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private String accountHolder;
    private String accountType; // e.g., "SAVINGS" or "CHECKING"
    private List<String> history;

    public BankAccount(String name, String type, double initialDeposit) {
        this.accountHolder = name;
        this.accountType = type;
        this.balance = initialDeposit;
        this.history = new ArrayList<>();
        history.add("Account opened with $" + initialDeposit);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        balance -= amount;
        history.add("Withdrew: $" + amount);
    }

    public boolean isAccountType(String type) {
        return this.accountType == type;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return history;
    }

    public void printSummary(){
        System.out.println("Holder: " + accountHolder + " | Balance: " + balance);
    }
}