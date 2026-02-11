package model;

public class Rental {
    private int rentalId;
    private String carId;
    private String customerId;
    private int days;
    private double totalPrice;

    public Rental(int rentalId, String carId, String customerId, int days, double totalPrice) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerId = customerId;
        this.days = days;
        this.totalPrice = totalPrice;
    }

    public Rental(String carId, String customerId, int days, double totalPrice) {
        this.carId = carId;
        this.customerId = customerId;
        this.days = days;
        this.totalPrice = totalPrice;
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getCarId() {
        return carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getDays() {
        return days;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
