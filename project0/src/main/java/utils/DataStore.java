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

    public static UserAccount getUser() {
        return user;
    }

    public static UserAccountRepo getUserRepo() {
        return userRepo;
    }

    public static BankAccount getBank() {
        return bank;
    }

    public static BankAccountRepo getBankRepo() {
        return bankRepo;
    }

    // create new objects for DataStore
    public static void initializeDataStore() {
        user = new UserAccount();
        userRepo = new UserAccountRepo();
        bank = new BankAccount();
        bankRepo = new BankAccountRepo();
    }

}
