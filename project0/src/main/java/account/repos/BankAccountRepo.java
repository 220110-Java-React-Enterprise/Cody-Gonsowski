package account.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.BankAccount;
import database.ConnectionManager;
import database.DataSourceCRUD;
import list.CustomArrayList;

public class BankAccountRepo implements DataSourceCRUD<BankAccount> {

    private Connection connection;

    public BankAccountRepo() {
        connection = ConnectionManager.getConnection();
    }


    @Override
    public BankAccount create(BankAccount model) {
        try {
            String sql = "INSERT INTO accounts (customer_id, balance) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getCustomerId());
            ps.setDouble(2, model.getBalance());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


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
                model.setAccountId(rs.getInt("account_id"));
                model.setCustomerId(rs.getInt("customer_id"));
                model.setBalance(rs.getDouble("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    @Override
    public BankAccount update(BankAccount model) {
        try {
            String sql = "UPDATE accounts SET customer_id = ?, balance = ? WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getCustomerId());
            ps.setDouble(2, model.getBalance());
            ps.setInt(3, model.getAccountId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


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
     * Retrieves all accounts associated with the provided customer id
     * @param id customer id of associated account to look for
     * @return List of associated accounts.
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
                model.setAccountId(rs.getInt("account_id"));
                model.setCustomerId(rs.getInt("customer_id"));
                model.setBalance(rs.getDouble("balance"));

                // marshall into list
                list.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
