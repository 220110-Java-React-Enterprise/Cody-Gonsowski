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
     * @param cid customer id to link to account
     * @param aid account id to link to customer
     */
    public void linkAccount(Integer cid, Integer aid) {
        try {
            // make query
            String sql = "INSERT INTO accounts_customers (customer_id, account_id) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, aid);

            // run the update
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
