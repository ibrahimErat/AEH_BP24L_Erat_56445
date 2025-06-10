package pl.pp;

// Explicit imports are not strictly needed as classes are in the same package.
// import pl.pp.Person;
// import pl.pp.Circle; 
// import pl.pp.Warehouse;
 
public class myNinthApp { // Renamed class to match filename
    public static void main(String[] args) {
/*
        // --- Original Lab 9 Demonstration ---
        System.out.println("--- Lab 9 Demonstration ---");

        // --- Person Demo ---
        // NOTE: Lab 9 instructions mention Person fields should be private,
        // but the provided Person class code uses public fields.
        // The direct access below works because of this.
        System.out.println("\n--- Person Demo ---");
        Person person1 = new Person(); 
        person1.hiToAll(); 
 
        person1.forename = "John";
        person1.surname = "Doe";
        person1.age = 24;
        person1.hiToAll(); 

        Person person2 = new Person("Alice", "Hart", 42);
        person2.hiToAll();
 
        person1.growOld(); // Uses Person.growOld() without arguments
        for(int i=0; i<3; i++) {
            person2.growOld();
        }
        person1.hiToAll();
        person2.hiToAll();
 
        System.out.println(person1.getName()); 
        person1.setName("Lolo"); 
        System.out.println(person1.getName()); 
        person1.hiToAll();

        // --- Circle Demo (using private field and getter/setter) ---
        // This part correctly demonstrates private fields and access via methods.
        System.out.println("\n--- Circle Demo ---");
        Circle circle1 = new Circle(); 
        circle1.setRadius(5.0); 
        System.out.println("Circle 1 Radius: " + circle1.getRadius()); 
        circle1.getInfo();

        Circle circle2 = new Circle(12.5); 
        circle2.getInfo();

        System.out.println("\nAttempting to set negative radius for circle2:");
        circle2.setRadius(-3.0);
        circle2.getInfo(); 

        System.out.println("\n--- End of Demonstration ---");
*/
        // --- Lab 9 Task 2: Warehouse Demonstration ---
        System.out.println("\n--- Warehouse Demonstration ---");

        // Create a new warehouse
        Warehouse mainWarehouse = new Warehouse("W001", 5000.0, "Ibrahim Erat", "i.erat@warehouse.com", "555-0101");

        System.out.println("\n--- Performing Operations ---");
        // Add 3000 units
        mainWarehouse.addGoods(3000.0);

        // Remove 1000 units
        mainWarehouse.removeGoods(1000.0);

        // Add 2500 units (this should fill it up or exceed capacity)
        mainWarehouse.addGoods(2500.0);

        // Check occupancy
        System.out.println("\n--- Checking Occupancy ---");
        mainWarehouse.checkOccupancy();

        // Try to remove more than available
        System.out.println("\n--- Trying to Over-Remove ---");
        mainWarehouse.removeGoods(5000.0);

        // Update contact info
        System.out.println("\n--- Updating Contact Info ---");
        mainWarehouse.updateContact("ibrahim.e@new-warehouse.com", "555-0202");
        System.out.println("Owner Email: " + mainWarehouse.getOwnerEmail());
        System.out.println("Owner Phone: " + mainWarehouse.getOwnerPhone());

        System.out.println("\n--- End of Warehouse Demonstration ---");
    }
} 