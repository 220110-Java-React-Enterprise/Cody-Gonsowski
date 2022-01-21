package account.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.UserAccount;
import database.ConnectionManager;
import database.DataSourceCRUD;

public class UserAccontRepo implements DataSourceCRUD<UserAccount> {

    private Connection connection;

    public UserAccontRepo() {
        connection = ConnectionManager.getConnection();
    }


    @Override
    public UserAccount create(UserAccount model) {
        try {
            String sql = "INSERT INTO customers (first_name, last_name, email, password) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


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
    
}
