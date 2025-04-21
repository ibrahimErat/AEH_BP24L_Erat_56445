package pl.pp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class myFifthApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Character Pattern Printer ---");

        while (true) {
            try {
                System.out.print("\nEnter the character to print (or type 'exit' to quit): ");
                String charInput = scanner.next();

                if (charInput.equalsIgnoreCase("exit")) {
                    break;
                }
                if (charInput.length() != 1) {
                    System.out.println("Please enter a single character.");
                    continue;
                }
                char character = charInput.charAt(0);

                System.out.print("Enter the number of times to print the character per row: ");
                int charsPerRow = scanner.nextInt();

                System.out.print("Enter the number of lines to print: ");
                int numLines = scanner.nextInt();

                if (charsPerRow <= 0 || numLines <= 0) {
                    System.out.println("Number of characters per row and number of lines must be positive.");
                    continue;
                }

                // Call the new method
                printCharacterPattern(character, charsPerRow, numLines);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid character and positive integers.");
                scanner.nextLine(); // Consume the rest of the invalid line
            } catch (Exception e) {
                 System.out.println("An error occurred: " + e.getMessage());
                 scanner.nextLine(); // Consume the rest of the line in case of other errors
            }
        }

        scanner.close();
        System.out.println("Program finished.");
    }

    /**
     * Prints a pattern of a given character.
     * @param character The character to print.
     * @param charsPerRow How many times the character should be printed in a row.
     * @param numLines The number of lines to print.
     */
    private static void printCharacterPattern(char character, int charsPerRow, int numLines) {
        System.out.println("\nPrinting pattern for character '" + character + "':");
        for (int i = 0; i < numLines; i++) { // Outer loop for lines
            for (int j = 0; j < charsPerRow; j++) { // Inner loop for characters per row
                System.out.print(character);
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    // Removed the old calculateScore methods
} 