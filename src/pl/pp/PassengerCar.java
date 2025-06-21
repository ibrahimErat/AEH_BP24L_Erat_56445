package pl.pp;

public class PassengerCar extends Vehicle {
    private int numberOfDoors;

    public PassengerCar(String registrationNumber, String vinNumber, String color, double price,
                         double fuelConsumption, double fuelLevel, double mileage,
                         FuelType fuelType, int numberOfDoors) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, fuelType);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() + ", numberOfDoors=" + numberOfDoors + '}';
    }
} 