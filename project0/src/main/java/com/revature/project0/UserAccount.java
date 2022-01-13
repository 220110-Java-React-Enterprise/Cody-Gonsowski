package com.revature.project0;

/**
 * Simple Account class to handle user data and transactions.
 */
public class UserAccount {
    private String username;
    private String email;
    private String password;
    private CustomArrayList<BankAccount> bankAccounts;


    /**
     * Default constructor.
     *   Creates an account of balance 0 and name name.
     */
    public UserAccount() {
        this.username = "name";
        this.email = "name@name.name";
        this.password = "password";
        this.bankAccounts = new CustomArrayList<>();
    }


    /**
     * Parameterized constructor.
     *   Creates an account when given a username and an initial balance.
     * @param username username to set for account
     * @param balance initial balance of account
     */
    public UserAccount(String username, String email, double balance) {
        setUsername(username);
        setEmail(email);
    }


    /**
     * Gets username of account.
     * @return username of account
     */
    public String getUsername() {
        return this.username;
    }


    /**
     * Sets username of account if valid.
     * @param username username of account
     * @return true  - username set successfully
     *         false - username not set successfully
     */
    public boolean setUsername(String username) {
        if (Checker.isValid(username, "name")) {
            this.username = username;
            return true;
        }

        return false;
    }


    /**
     * Gets email of account.
     * @return email of account
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * Sets email of account if valid.
     * @param email email of account
     * @return true  - email set successfully
     *         false - email not set successfully
     */
    public boolean setEmail(String email) {
        if (Checker.isValid(email, "email")) {
            this.email = email;
            return true;
        }

        return false;
    }


    /**
     * Sets password of account.
     */
    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }


    /**
     * Gets password of account.
     * @return password of account
     */
    public String getPassword() {
        return this.password;
    }


    /**
     * Prints a list of all associated bank accounts alongside their balances.
     */
    public void printBankAccounts() {
        //TODO implement this
    }
}
