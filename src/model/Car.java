package model;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private double pricePerDay;
    private CarStatus status;

    public Car(String carId, String brand, String model, double pricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.status = CarStatus.AVAILABLE;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int days) {
        double total = pricePerDay * days;
        if (days >= 7) total *= 0.9; // discount
        return total;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
