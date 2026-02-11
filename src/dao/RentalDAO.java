package dao;

import util.DBConnection;
import java.sql.*;

public class RentalDAO {

    public void save(String carId, int customerId, int days) {

        String sql = "INSERT INTO rental(car_id, customer_id, days) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, carId);
            ps.setInt(2, customerId);   // ✅ int now
            ps.setInt(3, days);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByCarId(String carId) {

        String sql = "DELETE FROM rental WHERE car_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, carId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
