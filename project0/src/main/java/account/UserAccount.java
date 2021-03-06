package account;

import utils.Checker;

/**
 * Simple Account class to handle user data and transactions.
 */
public class UserAccount {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    /**
     * Empty constructor.
     */
    public UserAccount() { }


    /**
     * Parameterized constructor.
     *   Creates an account when given a name and an initial balance.
     * @param firstName first name to set for account
     * @param lastName last name to set for account
     * @param email email to set for account
     * @param password password to set for account
     */
    public UserAccount(Integer id, String firstName, String lastName, String email, String password) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

    
    /**
     * Gets id of user.
     * @return id of user
     */
    public Integer getId() {
        return this.id;
    }


    /**
     * Sets id of account.
     */
    public boolean setId(Integer id) {
        this.id = id;
        return true;
    }


    /**
     * Gets first name of user.
     * @return first name of user
     */
    public String getFirstName() {
        return this.firstName;
    }


    /**
     * Sets first name of user if valid.
     * @param name name of user
     * @return true  - first name set successfully
     *         false - first name not set successfully
     */
    public boolean setFirstName(String firstName) {
        if (Checker.isValid(firstName, "firstName")) {
            this.firstName = firstName;
            return true;
        }

        return false;
    }


    /**
     * Gets last name of user.
     * @return last name of user
     */
    public String getLastName() {
        return this.lastName;
    }


    /**
     * Sets last name of user if valid.
     * @param name last name of user
     * @return true  - last name set successfully
     *         false - last name not set successfully
     */
    public boolean setLastName(String lastName) {
        if (Checker.isValid(lastName, "lastName")) {
            this.lastName = lastName;
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
}
