package account.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.UserAccount;
import database.ConnectionManager;
import database.DataSourceCRUD;

public class UserAccountRepo implements DataSourceCRUD<UserAccount> {
    private Connection connection;

    
    /**
     * Retrieve the connection to database from ConnectionManager.
     */
    public UserAccountRepo() {
        connection = ConnectionManager.getConnection();
    }


    /**
     * Creates a new entry in database provided a filled out model.
     *   The id is auto-incremented and set into the returned model.
     * @param model model to insert
     * @return model provided + id
     */
    @Override
    public UserAccount create(UserAccount model) {
        try {
            String sql = "INSERT INTO customers (first_name, last_name, email, password) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getPassword());

            ps.executeUpdate();

            // set model id to auto generated customer_id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                model.setId(rs.getInt("customer_id"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    /**
     * Returns a model that is filled out based on the given customer id.
     * @param id customer id to read info from
     * @return filled out model
     */
    @Override
    public UserAccount read(Integer id) {
        // model to fill out
        UserAccount model = new UserAccount();

        try {
            // make query
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            // get results
            ResultSet rs = ps.executeQuery();

            // fetch stuff from result set
            //   if multiple, marshal List<Model> instead of just Model
            while (rs.next()) {
                model.setId(rs.getInt("customer_id"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));
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
    public UserAccount update(UserAccount model) {
        try {
            String sql = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, password = ? WHERE customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getPassword());
            ps.setInt(5, model.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    /**
     * Deletes an entry from the database when provided with the customer id.
     * @param id customer id of entry to delete
     */
    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM customers WHERE customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Searches through customer accounts for a given email.
     * @param email email to look for
     * @return true - email already exists
     *         false - email does not exist
     */
    public boolean doesEmailExist(String email) {
        try {
            // make query
            String sql = "SELECT * FROM customers WHERE email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            // get results
            ResultSet rs = ps.executeQuery();

            // return true if there is anything in result set
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * Compares a possible given password to the stored password of a given email.
     * @param email email to look for
     * @param password password to compare
     * @return true - password matches
     *         false - password does not match
     */
    public boolean doesPasswordMatch(String email, String password) {
        try {
            // make query
            String sql = "SELECT * FROM customers WHERE email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            // get results
            ResultSet rs = ps.executeQuery();

            // return true if there is anything in result set
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * Retrieve a user's info given their email.
     * @param email email associated with user account
     * @return account details as a model
     */
    public UserAccount retrieveUserInfo(String email) {
        // model to fill out
        UserAccount model = new UserAccount();

        try {
            // make query
            String sql = "SELECT * FROM customers WHERE email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            // get results
            ResultSet rs = ps.executeQuery();

            // fetch stuff from result set
            while (rs.next()) {
                model.setId(rs.getInt("customer_id"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
}
