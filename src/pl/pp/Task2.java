package pl.pp;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Part 1: Calculate and display x, double of x, and x squared
        int x = 10;
        int doubleX = x * 2;
        int xSquared = x * x;

        System.out.println("x = " + x);
        System.out.println("Double of x = " + doubleX);
        System.out.println("x squared = " + xSquared);

        // Part 2: Convert age to seconds
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter your age in years:");
        int ageInYears = scanner.nextInt();
        
        // Convert age to seconds
        // 1 year = 365 days * 24 hours * 60 minutes * 60 seconds
        long ageInSeconds = (long)ageInYears * 365 * 24 * 60 * 60;
        
        System.out.println("My age in seconds: " + ageInSeconds);
        
        scanner.close();
    }
} 