import java.util.ArrayList;

/**
 * The "Amount" class represents a transaction amount with a type (e.g., "Deposit" or "Withdrawal").
 */
class Amount {
    private double amount;
    private String transactionType;

    /**
     * Constructs an "Amount" object with the given amount and transaction type.
     *
     * @param amount          The transaction amount.
     * @param transactionType The type of transaction (e.g., "Deposit" or "Withdrawal").
     */
    public Amount(double amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    /**
     * Retrieves the transaction amount.
     *
     * @return The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the transaction type.
     *
     * @return The transaction type.
     */
    public String getTransactionType() {
        return transactionType;
    }
}

/**
 * The "PersonalAccount" class represents a personal bank account with account details and transaction history.
 */
public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Amount> transactions;

    /**
     * Constructs a "PersonalAccount" object with the given account number and account holder.
     * Initializes the balance to 0.0 and creates an empty transactions list.
     *
     * @param accountNumber The unique identifier for the account.
     * @param accountHolder The name of the account holder.
     */
    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Deposits money into the account, adds the deposit transaction to the transaction history,
     * and updates the account balance.
     *
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions.add(new Amount(amount, "Deposit"));
        }
    }

    /**
     * Withdraws money from the account, adds the withdrawal transaction to the transaction history,
     * and updates the account balance. Ensures that the withdrawal amount does not exceed the current balance.
     *
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            transactions.add(new Amount(amount, "Withdrawal"));
        }
    }

    /**
     * Prints the transaction history (all transactions) of the account.
     */
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account #" + accountNumber);
        for (Amount transaction : transactions) {
            System.out.println(transaction.getTransactionType() + ": $" + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        // Sample Usage
        PersonalAccount account = new PersonalAccount(12345, "John Doe");
        account.deposit(1000.0);
        account.withdraw(500.0);
        account.deposit(200.0);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: $" + account.getBalance());
        account.printTransactionHistory();
    }
}
