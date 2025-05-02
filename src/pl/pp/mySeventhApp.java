package pl.pp;

// Removed explicit import as Person is in the same package
 
public class mySeventhApp {
    public static void main(String[] args) {
        System.out.println("--- Lab 7 Task 2 Demonstration ---");

        Person person1 = new Person(); // Uses default constructor
        System.out.print("Person 1 Initial: ");
        person1.hiToAll(); 
 
        person1.forename = "John";
        person1.surname = "Doe";
        person1.age = 24;
        person1.setAddress("123 Main St"); // Use setter for address
        person1.setYearOfBirth(java.time.Year.now().getValue() - person1.age); // Set year of birth
        System.out.print("Person 1 After Setting: ");
        person1.hiToAll(); 
 
        // Initialize using parameterized constructor
        Person person2 = new Person("Alice", "Hart", 42);
        person2.setAddress("456 Oak Ave"); // Set address after creation
        System.out.print("Person 2 Initial: ");
        person2.hiToAll();
 
        // Demonstrate modified growOld() and new beYounger()
        System.out.println("\n--- Modifying Ages ---");
        int newAge1 = person1.growOld(5); // Increase age by 5
        System.out.println("Person 1 grew older by 5 years. New age: " + newAge1);
        person1.hiToAll();

        int newAge2 = person2.beYounger(); // Decrease age by 1
        System.out.println("Person 2 became younger by 1 year. New age: " + newAge2);
        person2.hiToAll();

        newAge2 = person2.growOld(10); // Increase age by 10
        System.out.println("Person 2 grew older by 10 years. New age: " + newAge2);
        person2.hiToAll();

        // Demonstrate getName/setName again
        System.out.println("\n--- Testing Name Get/Set ---");
        System.out.println("Person 1 current name: " + person1.getName()); 
        person1.setName("Johnny"); 
        System.out.println("Person 1 new name: " + person1.getName()); 
        person1.hiToAll();

        System.out.println("\n--- End of Demonstration ---");
    }
} 