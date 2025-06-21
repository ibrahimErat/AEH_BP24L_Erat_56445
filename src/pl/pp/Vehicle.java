package pl.pp;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String vinNumber;
    protected String color;
    protected double price;
    protected double fuelConsumption; // liters per 100 km
    protected double fuelLevel; // liters
    protected double mileage; // km
    protected FuelType fuelType;

    public Vehicle(String registrationNumber, String vinNumber, String color, double price,
                    double fuelConsumption, double fuelLevel, double mileage, FuelType fuelType) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.color = color;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
        this.fuelType = fuelType;
    }

    public void drive(double distance) {
        double fuelNeeded = (fuelConsumption / 100.0) * distance;
        if (fuelNeeded > fuelLevel) {
            System.out.println("Not enough fuel to drive " + distance + " km.");
            return;
        }
        fuelLevel -= fuelNeeded;
        mileage += distance;
        System.out.println(getClass().getSimpleName() + " drove " + distance + " km. Remaining fuel: " + String.format("%.2f", fuelLevel) + " l.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(getClass().getSimpleName() + " refueled " + amount + " l. Current fuel: " + String.format("%.2f", fuelLevel) + " l.");
    }

    public String getFuelType() {
        return fuelType.getFuelType();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelLevel=" + fuelLevel +
                ", mileage=" + mileage +
                ", fuelType=" + getFuelType() +
                '}';
    }
} 