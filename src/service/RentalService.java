package service;

import dao.CarDAO;
import dao.RentalDAO;
import model.Car;
import model.CarStatus;
import model.Customer;

public class RentalService {

    private CarDAO carDAO = new CarDAO();
    private RentalDAO rentalDAO = new RentalDAO();

    public void rentCar(String carId, Customer customer, int days) {

        Car car = carDAO.findById(carId);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.getStatus() != CarStatus.AVAILABLE) {
            System.out.println("Car is not available.");
            return;
        }

        double totalPrice = car.calculatePrice(days);

        carDAO.updateStatus(carId, CarStatus.RENTED);
        rentalDAO.save(carId, customer.getCustomerId(), days);

        System.out.println("Car rented successfully!");
        System.out.printf("Total Price: %.2f%n", totalPrice);
    }

    public void returnCar(String carId) {

        Car car = carDAO.findById(carId);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.getStatus() != CarStatus.RENTED) {
            System.out.println("This car is not currently rented.");
            return;
        }

        carDAO.updateStatus(carId, CarStatus.AVAILABLE);
        rentalDAO.deleteByCarId(carId);

        System.out.println("Car returned successfully!");
    }
}
