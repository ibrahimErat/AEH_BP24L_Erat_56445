package pl.pp;

public class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String registrationNumber, String vinNumber, String color, double price,
                  double fuelConsumption, double fuelLevel, double mileage,
                  FuelType fuelType, double loadCapacity) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", loadCapacity=" + loadCapacity + " tons" + '}';
    }
} 