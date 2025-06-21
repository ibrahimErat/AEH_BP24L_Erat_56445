package pl.pp;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String vinNumber, String color, double price,
                       double fuelConsumption, double fuelLevel, double mileage,
                       FuelType fuelType, boolean hasSidecar) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, fuelType);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasSidecar=" + hasSidecar + '}';
    }
} 