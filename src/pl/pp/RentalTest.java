package pl.pp;

public class RentalTest {
    public static void main(String[] args) {
        FuelType diesel = new DieselEngine();
        FuelType gasoline = new GasolineEngine();
        FuelType electric = new ElectricEngine();

        PassengerCar car = new PassengerCar("KR12345", "VIN123CAR", "Red", 200.0,
                6.5, 50, 120_000, gasoline, 5);

        Truck truck = new Truck("KR54321", "VINTRUCK123", "Blue", 400.0,
                15, 150, 300_000, diesel, 18);

        Motorcycle moto = new Motorcycle("KR99999", "VINMOTO123", "Black", 100.0,
                4.0, 20, 20_000, gasoline, false);

        ConstructionEquipment excavator = new ConstructionEquipment("KR88888", "VINEX123", "Yellow", 800.0,
                20, 200, 10_000, diesel, 1500);

        // Display vehicles
        System.out.println(car);
        System.out.println(truck);
        System.out.println(moto);
        System.out.println(excavator);

        // Perform some actions
        car.drive(150);
        truck.drive(300);
        moto.drive(50);
        excavator.addWorkHours(8);

        car.refuel(20);
        truck.refuel(100);

        System.out.println("\nAfter actions:\n");
        System.out.println(car);
        System.out.println(truck);
        System.out.println(moto);
        System.out.println(excavator);
    }
} 