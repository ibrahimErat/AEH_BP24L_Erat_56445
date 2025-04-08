package pl.pp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Part 1: Sum of Squares ---
        System.out.println("--- Sum of Squares Calculator ---");
        while (true) {
            System.out.print("Enter lower and upper integer limits: ");
            try {
                int lower = scanner.nextInt();
                int upper = scanner.nextInt();

                if (upper <= lower) {
                    System.out.println("Done");
                    break; // Exit loop if upper <= lower
                }

                long sumOfSquares = 0;
                for (int i = lower; i <= upper; i++) {
                    sumOfSquares += (long)i * i; // Use long to prevent overflow
                }
                 // Displaying squares of the limits, not the range itself as per example
                 long lowerSquare = (long)lower * lower;
                 long upperSquare = (long)upper * upper;

                System.out.printf("The sums of the squares from %d to %d is %d%n",
                                  lowerSquare, upperSquare, sumOfSquares);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.next(); // Consume the invalid input
            }
        }

        // --- Part 2: Simple Calculator ---
        System.out.println("\n--- Simple Calculator ---");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                 choice = scanner.nextInt();

                 if (choice == 5) {
                     System.out.println("Exiting calculator...");
                     break; // Exit calculator loop
                 }

                 if (choice < 1 || choice > 4) {
                    System.out.println("Invalid option. Please choose between 1 and 5.");
                    continue; // Ask for menu choice again
                 }

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;

                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, result);
                        break;
                    case 2:
                        result = num1 - num2;
                         System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, result);
                        break;
                    case 3:
                        result = num1 * num2;
                         System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, result);
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("Error: Cannot divide by zero.");
                            validOperation = false;
                        } else {
                            result = num1 / num2;
                            System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                        }
                        break;
                     // Default case is covered by the check (choice < 1 || choice > 4)
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid token
            }
        }

        scanner.close();
        System.out.println("\nProgram finished.");
    }
} 