/**
 * Simple Account class to handle user data and transactions.
 */
public class BankAccount {
    private double balance;


    /**
     * Default constructor.
     *   Creates an account of balance 0 and name name.
     */
    public BankAccount() {
        this.balance = 0;
    }


    /**
     * Parameterized constructor.
     *   Creates an account when given a username and an initial balance.
     * @param username username to set for account
     * @param balance initial balance of account
     */
    public BankAccount(double balance) {
        setBalance(balance);
    }


    /**
     * Gets current account balance.
     * @return current account balance
     */
    public double getBalance() {
        return this.balance;
    }


    /**
     * Sets current account balance.
     * @return current account balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Deposits an amount to account's balance if amount is positive.
     * @param amount amount to deposit to account
     * @throws InvalidAmountException
     */
    public void deposit(double amount) throws InvalidAmountException {
        // invalid deposit amount
        if (amount <= 0) {
            throw new InvalidAmountException("Negative deposit amount!");
        }

        // update balance provided amount
        this.balance += amount;
    }
    

    /**
     * Withdrawals an amount from account's balance if amount is positive
     *   and the account's balance is sufficient.
     * @param amount amount to withdrawal from account
     * @throws InvalidAmountException
     */
    public void withdrawal(double amount) throws InvalidAmountException {
        // invalid withdrawal amount
        if (amount <= 0) {
            throw new InvalidAmountException("Negative withdrawal amount!");
        }

        // not enough money in account
        if (this.balance < amount) {
            throw new InvalidAmountException("Insufficient funds!");
        }

        // update balance provided amount
        this.balance -= amount;
    }
}
