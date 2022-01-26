package account.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.BankAccount;
import database.ConnectionManager;
import database.DataSourceCRUD;
import list.CustomArrayList;
import utils.InvalidAmountException;

public class BankAccountRepo implements DataSourceCRUD<BankAccount> {
    private Connection connection;


    /**
     * Retrieve the connection to database from ConnectionManager.
     */
    public BankAccountRepo() {
        connection = ConnectionManager.getConnection();
    }


    /**
     * Creates a new entry in database provided a filled out model.
     *   The id is auto-incremented and set into the returned model.
     * @param model model to insert
     * @return model provided + id
     */
    @Override
    public BankAccount create(BankAccount model) {
        try {
            String sql = "INSERT INTO accounts (balance) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, model.getBalance());

            ps.executeUpdate();

            // set model id to auto generated account_id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                model.setId(rs.getInt("account_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    /**
     * Returns a model that is filled out based on the given account id.
     * @param id account id to read info from
     * @return filled out model
     */
    @Override
    public BankAccount read(Integer id) {
        // model to fill out
        BankAccount model = new BankAccount();

        try {
            // make query
            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            // get results
            ResultSet rs = ps.executeQuery();

            // fetch stuff from result set
            //   if multiple, marshal List<Model> instead of just Model
            while (rs.next()) {
                model.setId(rs.getInt("account_id"));
                model.setBalance(rs.getDouble("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    /**
     * Updates all non-id database info of a provided model based on the model's id.
     * @param model model with info to be changed
     * @return provided model
     */
    @Override
    public BankAccount update(BankAccount model) {
        try {
            String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, model.getBalance());
            ps.setInt(2, model.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    /**
     * Deletes an entry from the database when provided with the account id.
     * @param id account id of entry to delete
     */
    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM accounts WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Retrieves all accounts associated with the provided customer id.
     * @param id customer id of associated account to look for
     * @return list of associated accounts
     */
    public CustomArrayList<BankAccount> accountsOfCustomer(Integer id) {
        // model to fill out
        BankAccount model;
        CustomArrayList<BankAccount> list = new CustomArrayList<>();

        try {
            // make query
            String sql = "SELECT * FROM accounts a JOIN accounts_customers ac ON a.account_id = ac.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE c.customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            // get results
            ResultSet rs = ps.executeQuery();

            // fetch stuff from result set
            //   if multiple, marshal List<Model> instead of just Model
            while (rs.next()) {
                // reset values
                model = new BankAccount();

                // update values
                model.setId(rs.getInt("account_id"));
                model.setBalance(rs.getDouble("balance"));

                // marshall into list
                list.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    
    /**
     * Ties an existing customer account to an existing bank account through a junction table.
     * @param customer_id customer id to link to account
     * @param account_id account id to link to customer
     */
    public void linkAccount(Integer customer_id, Integer account_id) {
        try {
            // make query
            String sql = "INSERT INTO accounts_customers (customer_id, account_id) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer_id);
            ps.setInt(2, account_id);

            // run the update
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Perform a deposit provided the amount to deposit and the account to deposit to.
     *   Checks if the amount is positive.
     * @param amount amount to deposit; this should be positive
     * @param account_id account to deposit to
     * @throws InvalidAmountException
     */
    public void deposit(Double amount, Integer account_id) throws InvalidAmountException {
        // invalid deposit amount
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount!");
        }

        // persist in database
        try {
            // make query
            String sql = "UPDATE accounts SET balance = (balance + ?) WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, account_id);

            // run the update
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Perform a withdrawal provided the amount to withdraw and the account to withdraw from.
     *   Checks if the amount is positive.
     *   Checks if the balance is sufficient.
     * @param amount amount to withdraw; this should be positive
     * @param account_id account to withdraw from
     * @throws InvalidAmountException
     */
    public void withdrawal(Double amount, Integer account_id) throws InvalidAmountException {
        // invalid deposit amount
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount!");
        }

        // not enough money in account
        if ((read(account_id).getBalance() - amount) < 0) {
            throw new InvalidAmountException("Insufficient funds!");
        }

        // persist in database
        try {
            // make query
            String sql = "UPDATE accounts SET balance = (balance - ?) WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, account_id);

            // run the update
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
