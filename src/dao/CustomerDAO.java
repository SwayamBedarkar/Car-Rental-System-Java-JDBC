package dao;

import model.Customer;
import util.DBConnection;

import java.sql.*;

public class CustomerDAO {

    public Customer save(String name) {

        String sql = "INSERT INTO customer(name) VALUES (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int generatedId = rs.getInt(1);
                return new Customer(generatedId, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
