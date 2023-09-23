import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalAccountTest {
    private PersonalAccount account;

    @BeforeEach
    public void setUp() {
        account = new PersonalAccount(12345, "John Doe");
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(1000.0);
        assertEquals(1000.0, account.getBalance());

        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(1000.0);
        account.withdraw(500.0);
        assertEquals(500.0, account.getBalance());

        account.withdraw(200.0);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void testWithdrawWithInsufficientBalance() {
        account.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(1000.0);
        account.withdraw(500.0);
        account.deposit(200.0);

        String expectedHistory = "Transaction History for Account #12345\n" +
                "Deposit: $1000.0\n" +
                "Withdrawal: $500.0\n" +
                "Deposit: $200.0\n";
        assertEquals(expectedHistory, getTransactionHistoryString());
    }

    private String getTransactionHistoryString() {
        // Helper method to get the transaction history as a string for testing
        StringBuilder history = new StringBuilder();
        for (Amount transaction : account.getTransactions()) {
            history.append(transaction.getTransactionType()).append(": $").append(transaction.getAmount()).append("\n");
        }
        return "Transaction History for Account #" + account.getAccountNumber() + "\n" + history.toString();
    }
}
