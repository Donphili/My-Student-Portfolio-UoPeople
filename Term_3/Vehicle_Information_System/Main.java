import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Information System!");
        int choice;
        do {
            System.out.println("Please choose an option:");
            System.out.println("1. Create a new vehicle");
            System.out.println("2. Display vehicle details");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createNewVehicle();
                    break;
                case 2:
                    displayVehicleDetails();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (choice != 3);
    }

    private static void createNewVehicle() {
        System.out.println("Creating a new vehicle...");
        System.out.println("Enter vehicle type (Car, Motorcycle, or Truck):");
        String vehicleType = scanner.nextLine();

        Vehicle vehicle;
        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicle = createCar();
                break;
            case "motorcycle":
                vehicle = createMotorcycle();
                break;
            case "truck":
                vehicle = createTruck();
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle created successfully.");
    }

    private static Vehicle createCar() {
        Car car = new Car();
        setVehicleDetails(car);
        System.out.println("Enter number of doors:");
        int numberOfDoors = scanner.nextInt();
        car.setNumberOfDoors(numberOfDoors);
        System.out.println("Enter fuel type:");
        String fuelType = scanner.next();
        car.setFuelType(fuelType);
        return car;
    }

    private static Vehicle createMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();
        setVehicleDetails(motorcycle);
        System.out.println("Enter number of wheels:");
        int numberOfWheels = scanner.nextInt();
        motorcycle.setNumberOfWheels(numberOfWheels);
        System.out.println("Enter motorcycle type:");
        String motorcycleType = scanner.next();
        motorcycle.setMotorcycleType(motorcycleType);
        return motorcycle;
    }

    private static Vehicle createTruck() {
        Truck truck = new Truck();
        setVehicleDetails(truck);
        System.out.println("Enter cargo capacity (in tons):");
        double cargoCapacity = scanner.nextDouble();
        truck.setCargoCapacity(cargoCapacity);
        System.out.println("Enter transmission type:");
        String transmissionType = scanner.next();
        truck.setTransmissionType(transmissionType);
        return truck;
    }

    private static void setVehicleDetails(Vehicle vehicle) {
        System.out.println("Enter make:");
        String make = scanner.next();
        vehicle.setMake(make);
        System.out.println("Enter model:");
        String model = scanner.next();
        vehicle.setModel(model);
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        vehicle.setYear(year);
    }

    private static void displayVehicleDetails() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
        } else {
            System.out.println("Displaying vehicle details:");
            for (Vehicle vehicle : vehicles) {
                System.out.println("Make: " + vehicle.getMake());
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Year: " + vehicle.getYear());
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    System.out.println("Number of Doors: " + car.getNumberOfDoors());
                    System.out.println("Fuel Type: " + car.getFuelType());
                } else if (vehicle instanceof Motorcycle) {
                    Motorcycle motorcycle = (Motorcycle) vehicle;
                    System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
                    System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
                } else if (vehicle instanceof Truck) {
                    Truck truck = (Truck) vehicle;
                    System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
                    System.out.println("Transmission Type: " + truck.getTransmissionType());
                }
                System.out.println();
            }
        }
    }
}
