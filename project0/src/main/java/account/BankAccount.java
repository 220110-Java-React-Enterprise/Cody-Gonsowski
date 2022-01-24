package account;

import utils.InvalidAmountException;
/**
 * Simple Account class to handle user data and transactions.
 */
public class BankAccount {
    private Integer id;
    private Double balance;


    /**
     * Empty constructor.
     */
    public BankAccount() { }


    /**
     * Parameterized constructor.
     *   Creates an account when given a username and an initial balance.
     * @param balance initial balance of account
     */
    public BankAccount(Integer id, Double balance) {
        setId(id);
        setBalance(balance);
    }


    /**
     * Gets associated customer id.
     * @return associated customer id
     */
    public Integer getId() {
        return this.id;
    }


    /**
     * Sets associated customer id.
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets current account balance.
     * @return current account balance
     */
    public Double getBalance() {
        return this.balance;
    }


    /**
     * Sets current account balance.
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }


    /**
     * Deposits an amount to account's balance if amount is positive.
     * @param amount amount to deposit to account
     * @throws InvalidAmountException
     */
    public void deposit(Double amount) throws InvalidAmountException {
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
    public void withdrawal(Double amount) throws InvalidAmountException {
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
