package pl.pp;
 
public class Circle {
 
    private double radius; // Make the radius private
 
    public Circle() {
    }
 
    public Circle(double radius) {
        // Use the setter to ensure validation is applied
        setRadius(radius);
    }
 
    // Getter for radius
    public double getRadius() {
        return radius;
    }
 
    // Setter for radius
    public void setRadius(double radius) {
        // Basic validation: ensure radius is not negative
        if (radius >= 0) {
             this.radius = radius;
        } else {
             System.out.println("Radius cannot be negative. Setting to 0.");
             this.radius = 0;
        }
    }
 
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
 
    public double circumference() {
        return 2 * Math.PI * radius;
    }
 
    public void getInfo() {
        System.out.printf("Circle with radius = %.2f, area = %.2f and circumference = %.2f%n", 
                          radius, area(), circumference());
    }
} 