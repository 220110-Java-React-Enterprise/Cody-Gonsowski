package utils;
import account.BankAccount;
import account.UserAccount;
import account.repos.BankAccountRepo;
import account.repos.UserAccountRepo;

public class DataStore {
    static UserAccount user;
    static UserAccountRepo userRepo;
    static BankAccount bank;
    static BankAccountRepo bankRepo;

    
    /**
     * Load the new instances of static objects associated with DataStore.
     *   Feels more appropriate than setting them in a constructor.
     */
    public static void initializeDataStore() {
        user = new UserAccount();
        userRepo = new UserAccountRepo();
        bank = new BankAccount();
        bankRepo = new BankAccountRepo();
    }


    /**
     * Returns static instance of UserAccount.
     * @return user
     */
    public static UserAccount getUser() {
        return user;
    }


    /**
     * Updates static instance of UserAccount.
     * @param newUser the instance of UserAccount to update user to
     */
    public static void setUser(UserAccount newUser) {
        user = newUser;
    }


    /**
     * Returns static instance of UserAccountRepo.
     * @return userRepo
     */
    public static UserAccountRepo getUserRepo() {
        return userRepo;
    }


    /**
     * Returns static instance of BankAccount.
     * @return bank
     */
    public static BankAccount getBank() {
        return bank;
    }


    /**
     * Updates static instance of BankAccount.
     * @param newBank the instance of BankAccount to update user to
     */
    public static void setBank(BankAccount newBank) {
        bank = newBank;
    }


    /**
     * Returns static instance of BankAccountRepo.
     * @return bankRepo
     */
    public static BankAccountRepo getBankRepo() {
        return bankRepo;
    }

}
