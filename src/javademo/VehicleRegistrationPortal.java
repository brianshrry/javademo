package javademo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VehicleRegistrationPortal {
    private static ArrayList<String> vehicleNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Vehicle Registration Portal");
            System.out.println("1. Add vehicle number");
            System.out.println("2. Delete vehicle number");
            System.out.println("3. Search vehicle number");
            System.out.println("4. Display all vehicle numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addVehicleNumber(scanner);
                    break;
                case "2":
                    deleteVehicleNumber(scanner);
                    break;
                case "3":
                    searchVehicleNumber(scanner);
                    break;
                case "4":
                    displayVehicleNumbers();
                    break;
                case "5":
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private static void addVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number to add (uppercase only): ");
        String vehicleNumber = scanner.nextLine();
        if (vehicleNumber.matches("[a-z]+")) {
            System.out.println("Invalid vehicle number, only uppercase letters and numbers are allowed");
            return;
        }
        vehicleNumbers.add(vehicleNumber);
        System.out.println("Vehicle number added successfully");
    }

    private static void deleteVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number to delete: ");
        String vehicleNumber = scanner.nextLine();
        if (vehicleNumbers.remove(vehicleNumber)) {
            System.out.println("Vehicle number deleted successfully");
        } else {
            System.out.println("Vehicle number not found");
        }
    }

    private static void searchVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number to search: ");
        String vehicleNumber = scanner.nextLine().toUpperCase();
        if (vehicleNumbers.contains(vehicleNumber)) {
            System.out.println("Vehicle number found");
        } else {
            System.out.println("Vehicle number not found");
        }
    }

    private static void displayVehicleNumbers() {
        Collections.sort(vehicleNumbers);
        System.out.println("Vehicle numbers in ascending order:");
        for (String vehicleNumber : vehicleNumbers) {
            System.out.println(vehicleNumber);
        }
    }
}
