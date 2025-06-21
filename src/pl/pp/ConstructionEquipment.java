package pl.pp;

public class ConstructionEquipment extends Vehicle {
    private double hoursWorked;

    public ConstructionEquipment(String registrationNumber, String vinNumber, String color, double price,
                                  double fuelConsumption, double fuelLevel, double mileage,
                                  FuelType fuelType, double hoursWorked) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, fuelType);
        this.hoursWorked = hoursWorked;
    }

    public void addWorkHours(double hours) {
        this.hoursWorked += hours;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + ", hoursWorked=" + hoursWorked + " h" + '}';
    }
} 