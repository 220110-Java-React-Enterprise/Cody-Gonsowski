package account;

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
}
