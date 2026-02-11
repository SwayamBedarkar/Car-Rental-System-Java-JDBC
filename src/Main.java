import model.Customer;
import service.CarService;
import service.CustomerService;
import service.RentalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CarService carService = new CarService();
        CustomerService customerService = new CustomerService();
        RentalService rentalService = new RentalService();

        while (true) {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                Customer customer = customerService.addCustomer(name);

                System.out.println("\nAvailable Cars:");
                carService.showAvailableCars();

                System.out.print("\nEnter car ID: ");
                String carId = sc.nextLine().trim().toUpperCase();

                System.out.print("Enter days: ");
                int days = sc.nextInt();
                sc.nextLine();

                // Validate car exists
                if (carService.getCarById(carId) == null) {
                    System.out.println("Invalid car ID. Car not found.");
                    continue;
                }

                rentalService.rentCar(carId, customer, days);
            }


            else if (choice == 2) {
                System.out.print("Enter car ID: ");
                String carId = sc.nextLine().trim().toUpperCase();

                if (carService.getCarById(carId) == null) {
                    System.out.println("Invalid car ID. Car not found.");
                    continue;
                }

                rentalService.returnCar(carId);
            }


            else if (choice == 3) {
                System.out.println("Thank you for using the system!");
                break;
            }

            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
