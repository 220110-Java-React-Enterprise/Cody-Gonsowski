package com.revature.project0;

/**
 * Simple Account class to handle user data and transactions.
 */
public class Account {
    String username;
    double balance;

    /**
     * Default constructor.
     *   Creates an account of balance 0 and name name.
     */
    public Account() {
        this.username = "name";
        this.balance = 0;
    }

    /**
     * Parameterized constructor.
     *   Creates an account when given a username and an initial balance.
     * @param username username to set for account
     * @param balance initial balance of account
     */
    public Account(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    /**
     * Gets current account balance.
     * @return current account balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Gets username of account.
     * @return username of account
     */
    public String getUsername() {
        return this.username;
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
