package pl.pp;

// Since Person, Circle, and Account are in the same package, explicit imports are not strictly needed.
// import pl.pp.Person;
// import pl.pp.Circle; 
// import pl.pp.Account;
 
public class myEighthApp { // Renamed class to match filename
    public static void main(String[] args) {
/*
        // --- Original Lab 8 Demonstration ---
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
*/

        // --- Lab 8 Task 2: Account Demonstration ---
        System.out.println("\n--- Account Demonstration ---");

        // Create a new account
        Account myAccount = new Account("123456789", 1000.0, "Ibrahim Erat", "ibrahim.e@example.com", "555-1234");

        System.out.println("\n--- Performing Transactions ---");
        // Perform transactions as in the example
        myAccount.withdraw(900.0);
        myAccount.deposit(250.0);
        myAccount.withdraw(50.0);
        myAccount.withdraw(400.0); // This should fail

        // Demonstrate getters
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Owner: " + myAccount.getOwnerName());
        System.out.printf(java.util.Locale.US, "Final Balance: PLN %.2f%n", myAccount.getAvailableFunds());

         System.out.println("\n--- End of Account Demonstration ---");

    }
} 