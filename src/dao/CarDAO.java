package dao;

import model.Car;
import model.CarStatus;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class CarDAO {

    public void save(Car car) {
        String sql = "INSERT INTO car VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, car.getCarId());
            ps.setString(2, car.getBrand());
            ps.setString(3, car.getModel());
            ps.setDouble(4, car.calculatePrice(1)); // base
            ps.setString(5, car.getStatus().name());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car findById(String carId) {
        String sql = "SELECT * FROM car WHERE car_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, carId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Car car = new Car(
                        rs.getString("car_id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getDouble("price_per_day")
                );
                car.setStatus(CarStatus.valueOf(rs.getString("status")));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStatus(String carId, CarStatus status) {
        String sql = "UPDATE car SET status=? WHERE car_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status.name());
            ps.setString(2, carId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAvailableCars() {

        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car WHERE status = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, CarStatus.AVAILABLE.name());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("car_id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getDouble("price_per_day")
                );

                car.setStatus(CarStatus.valueOf(rs.getString("status")));
                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }


}
