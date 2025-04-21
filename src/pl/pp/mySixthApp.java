package pl.pp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mySixthApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Factorial Calculator (Iterative vs Recursive) ---");

        int n = -1;
        while (n < 0) {
            System.out.print("Enter a non-negative integer N: ");
            try {
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume invalid input
                n = -1; // Reset n to retry loop
            }
        }

        // --- Iterative Factorial ---
        long startTimeIterative = System.nanoTime();
        long resultIterative = factorialIterative(n);
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;

        if (resultIterative == -1) { // Check for potential overflow indication
             System.out.println("\nIterative Factorial: Result too large (overflow) or invalid input.");
        } else {
            System.out.println("\nIterative Factorial:");
            System.out.println("Result: " + resultIterative);
            System.out.println("Execution Time: " + durationIterative + " nanoseconds");
        }

        // --- Recursive Factorial ---
        long startTimeRecursive = System.nanoTime();
        long resultRecursive = -1; // Initialize
        try {
             resultRecursive = factorialRecursive(n);
             long endTimeRecursive = System.nanoTime();
             long durationRecursive = endTimeRecursive - startTimeRecursive;

             if (resultRecursive == -1) { // Check for potential overflow indication
                 System.out.println("\nRecursive Factorial: Result too large (overflow) or invalid input.");
             } else {
                 System.out.println("\nRecursive Factorial:");
                 System.out.println("Result: " + resultRecursive);
                 System.out.println("Execution Time: " + durationRecursive + " nanoseconds");
             }
        } catch (StackOverflowError e) {
            System.out.println("\nRecursive Factorial: StackOverflowError! Input N is likely too large for recursion.");
             System.out.println("Execution Time measurement aborted due to error.");
        }


        scanner.close();
        System.out.println("\nProgram finished.");
    }

    /**
     * Calculates factorial iteratively.
     * Uses long to handle larger results, but can still overflow.
     * Returns -1 if n is negative or if potential overflow occurs (result becomes negative).
     */
    public static long factorialIterative(int n) {
        if (n < 0) {
            return -1; // Factorial not defined for negative numbers
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            // Basic overflow check (if result becomes negative for positive factors)
            if (result < 0) {
                 System.err.println("Warning: Potential overflow detected during iterative calculation for n=" + n);
                 return -1;
            }
        }
        return result;
    }

    /**
     * Calculates factorial recursively.
     * Uses long to handle larger results, but can still overflow or cause StackOverflowError.
     * Returns -1 if n is negative.
     */
    public static long factorialRecursive(int n) {
        if (n < 0) {
            return -1; // Factorial not defined for negative numbers
        }
        if (n == 0 || n == 1) {
            return 1;
        }
         // Recursive call - potential StackOverflowError for large n
         long previousFactorial = factorialRecursive(n - 1);

         // Basic overflow check before multiplication
         // This check is not perfect but helps catch some cases.
         if (previousFactorial < 0 || (Long.MAX_VALUE / n < previousFactorial)) {
             System.err.println("Warning: Potential overflow detected during recursive calculation for n=" + n);
             return -1;
         }

        return n * previousFactorial;
    }
} 