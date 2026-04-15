package edu.sandiego.comp305;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Student", "CHECKING", 100.0);
    }

    @Test
    void testDepositIncreasesBalance() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Deposit should add to balance");
    }

    @Test
    void testHistoryTracking() {
        account.deposit(20.0);
        assertEquals(2, account.getHistory().size(), "History should have 2 entries");
        assertTrue(account.getHistory().get(1).contains("Deposited: $20.0"));
    }

    @Test
    void testWithdrawOverdraftProtection() {
        account.withdraw(150.0);
        assertTrue(account.getBalance() >= 0, "Balance should not drop below zero!");
    }

    @Test
    void testAccountTypeCheck() {
        // Creating a new String object forces a reference mismatch for ==
        String typeFromUser = new String("CHECKING");
        assertTrue(account.isAccountType(typeFromUser), "Account type check failed");
    }
}