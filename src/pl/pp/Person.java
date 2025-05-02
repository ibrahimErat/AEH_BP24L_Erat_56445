package pl.pp;
 
public class Person {
    // fields (attributes) of the class defining the object "Person" (its parameters/characteristics)
    public String forename; // field storing the feature forename
    public String surname; // field storing the feature surname
    public int age; // field storing the feature age
    public String address; // New field for address
    public int year_of_birth; // New field for year of birth
 
    /**
     * Default constructor - an element initializing object fields during its creation
     * (if we do not provide any parameters ourselves)
     */
    public Person() {
        // Initialize new fields to default values
        this.address = "Unknown";
        this.year_of_birth = 0;
    }
 
    /**
     * Constructor with three parameters, which we can provide at its creation
     * Updated to initialize new fields as well.
     */
    public Person(String initForename, String initSurname, int initAge) {
        this.forename = initForename;
        this.surname = initSurname;
        this.age = initAge;
        // Initialize new fields to default values even in this constructor
        // Or add parameters: (String initForename, String initSurname, int initAge, String initAddress, int initYearOfBirth)
        this.address = "Unknown";
        this.year_of_birth = java.time.Year.now().getValue() - initAge; // Estimate year of birth
    }
 
    // class methods defining actions possible to be performed by the object
    public void hiToAll(){
        // Updated to include new fields
        System.out.println("My name is " + forename + " " + surname + ". " 
                         + "I am " + age + " years old (Born approx. " + year_of_birth + "). "
                         + "Address: " + address);
    }
 
    /** 
     * Modified method growOld, which increases the age of the object 
     * by the value of the argument 'years'.
     * @param years The number of years to increase the age by.
     * @return The new age.
     */
    public int growOld(int years){
        if (years > 0) { // Only increase age if years is positive
            this.age = this.age + years;
        }
        return this.age;
    }

    /**
     * New method beYounger, which decreases the age by 1.
     * Includes a check to prevent age from going below 0.
     * @return The new age.
     */
    public int beYounger() {
        if (this.age > 0) {
            this.age = this.age - 1;
        }
        return this.age;
    }
 
    // example method getName returning the value of forename of the object
    public String getName(){
        return forename;
    }
 
    // example method setName setting the value of forename of the object
    public void setName(String nameToSet){
        forename = nameToSet;
    }

    // Optional: Add setters for new fields
    public void setAddress(String address) {
        this.address = address;
    }

    public void setYearOfBirth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
        // Optionally recalculate age if year of birth is set?
        // this.age = java.time.Year.now().getValue() - year_of_birth;
    }
} 