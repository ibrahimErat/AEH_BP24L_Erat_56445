package pl.pp;
 
public class Person {
    // fields (attributes) of the class defining the object "Person" (its parameters/characteristics)
    public String forename; // field storing the feature forename
    public String surname; // field storing the feature surname
    public int age; // field storing the feature age
 
    /**
     * Default constructor - an element initializing object fields during its creation
     * (if we do not provide any parameters ourselves)
     */
    public Person() {
        // NOTE: Lab 9 instructions mention fields should be private,
        // but the provided code uses public. Using public as provided.
    }
 
    /**
     * Constructor with three parameters, which we can provide at its creation
     */
    public Person(String initForename, String initSurname, int initAge) {
        forename = initForename;
        surname = initSurname;
        age = initAge;
    }
 
    // class methods defining actions possible to be performed by the object
    public void hiToAll(){
        System.out.println("My name is " + forename + " " + surname + ". " + "I am " + age + " years old.");
    }
 
    // example method growOld, which increases the age of the object by one each time it is called
    public int growOld(){
        // NOTE: Reverting to the version that takes no arguments as per the provided code.
        age = age + 1;
        return age;
    }
 
    // example method getName returning the value of forename of the object
    public String getName(){
        return forename;
    }
 
    // example method setName setting the value of forename of the object
    public void setName(String nameToSet){
        forename = nameToSet;
    }
    
    // Removing methods added in previous labs if they conflict with this version
    // public int growOld(int years){ ... } 
    // public int beYounger() { ... }
    // public String address; ...
    // public int year_of_birth; ...
} 