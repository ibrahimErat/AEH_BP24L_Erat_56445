package pl.pp;

// Since Person and Circle are in the same package, explicit imports are not strictly needed.
// import pl.pp.Person;
// import pl.pp.Circle; 
 
public class myEighthApp { // Renamed class to match filename
    public static void main(String[] args) {
        System.out.println("--- Lab 8 Demonstration ---");

        // --- Person Demo (using public fields as provided) ---
        System.out.println("\n--- Person Demo ---");
        Person person1 = new Person(); 
        person1.hiToAll(); 
 
        // Direct field access (works because fields in provided Person.java are public)
        person1.forename = "John";
        person1.surname = "Doe";
        person1.age = 24;
        person1.hiToAll(); 

        Person person2 = new Person("Alice", "Hart", 42);
        person2.hiToAll();
 
        person1.growOld(1); // Increases age by 1
        person2.growOld(1);
        person2.growOld(1);
        person2.growOld(1);

        person1.hiToAll();
        person2.hiToAll();
 
        System.out.println("Person 1 name: " + person1.getName()); 
        person1.setName("Lolo"); 
        System.out.println("Person 1 new name: " + person1.getName());
        person1.hiToAll();

        // --- Circle Demo (using private field and getter/setter) ---
        System.out.println("\n--- Circle Demo ---");
        Circle circle1 = new Circle(); // Default constructor
        circle1.setRadius(5.0); // Use setter to set private radius
        System.out.println("Circle 1 Radius: " + circle1.getRadius()); // Use getter
        circle1.getInfo();

        Circle circle2 = new Circle(12.5); // Constructor with radius
        circle2.getInfo();

        // Attempting to set a negative radius
        System.out.println("\nAttempting to set negative radius:");
        circle2.setRadius(-3.0);
        circle2.getInfo(); // Radius should be 0

        System.out.println("\n--- End of Demonstration ---");

    }
} 