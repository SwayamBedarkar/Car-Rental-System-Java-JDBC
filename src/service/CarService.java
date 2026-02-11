package service;

import dao.CarDAO;
import model.Car;

import java.util.List;

public class CarService {

    private CarDAO carDAO = new CarDAO();

    public List<Car> getAvailableCars() {
        return carDAO.getAvailableCars();
    }

    public Car getCarById(String carId) {
        return carDAO.findById(carId);
    }

    public void showAvailableCars() {
        List<Car> cars = getAvailableCars();

        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (Car car : cars) {
            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
        }
    }
}
