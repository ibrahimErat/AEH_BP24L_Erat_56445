package pl.pp;

import java.util.Scanner;

public class Task2Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Part 1: Days to weeks converter
        System.out.println("Part 1 - Days to Weeks Converter");
        System.out.println("--------------------------------");
        
        while (true) {
            System.out.println("\nEnter number of days (0 or negative to exit):");
            int days = scanner.nextInt();
            
            if (days <= 0) {
                System.out.println("Exiting days converter...");
                break;
            }
            
            int weeks = days / 7;
            int remainingDays = days % 7;
            
            System.out.printf("%d days is %d weeks and %d days%n", 
                            days, weeks, remainingDays);
        }
        
        // Part 2: Temperature converter
        System.out.println("\nPart 2 - Temperature Converter");
        System.out.println("------------------------------");
        
        while (true) {
            System.out.println("\nEnter temperature in Celsius (-1 to exit):");
            double celsius = scanner.nextDouble();
            
            if (celsius == -1) {
                System.out.println("Exiting temperature converter...");
                break;
            }
            
            double fahrenheit = 1.8 * celsius + 32.0;
            double kelvin = celsius + 273.16;
            
            System.out.printf("Temperature in Celsius: %.2f°C%n", celsius);
            System.out.printf("Temperature in Fahrenheit: %.2f°F%n", fahrenheit);
            System.out.printf("Temperature in Kelvin: %.2f K%n", kelvin);
        }
        
        scanner.close();
        System.out.println("\nProgram terminated.");
    }
} 