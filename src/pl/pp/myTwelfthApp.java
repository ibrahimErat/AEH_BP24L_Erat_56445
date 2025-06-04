package pl.pp;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths; // For getting filename from path

public class myTwelfthApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath;
        String outputFilePath;

        System.out.println("Enter the path to the input text file:");
        inputFilePath = scanner.nextLine();

        System.out.println("Enter the path to the output text file:");
        outputFilePath = scanner.nextLine();

        int lineCount = 0;
        boolean fileProcessedSuccessfully = false;

        while (!fileProcessedSuccessfully) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                }
                fileProcessedSuccessfully = true; // Mark as successful if reading completes

                System.out.println("The input file \"" + Paths.get(inputFilePath).getFileName() + "\" has " + lineCount + " lines.");

                try (FileWriter writer = new FileWriter(outputFilePath)) {
                    writer.write("Input File: " + Paths.get(inputFilePath).getFileName() + "\n");
                    writer.write("Number of Lines: " + lineCount + "\n");
                    System.out.println("Results saved to \"" + outputFilePath + "\"");
                } catch (IOException e) {
                    System.err.println("Error writing to the output file: " + e.getMessage());
                    // Decide if we should retry or exit. For now, we'll just report and continue (as input was read).
                }

            } catch (FileNotFoundException e) {
                System.err.println("Error: Input file not found: " + inputFilePath);
                System.out.println("Please enter a valid path for the input text file:");
                inputFilePath = scanner.nextLine(); // Ask for a new input file path
                lineCount = 0; // Reset line count for the new file
            } catch (IOException e) {
                System.err.println("Error reading the input file: " + e.getMessage());
                // For other IOExceptions, we might want to allow retrying or exit.
                // For simplicity here, if it's not FileNotFound, we'll prompt for a new file path as well.
                System.out.println("An error occurred. Please enter a valid path for the input text file:");
                inputFilePath = scanner.nextLine(); // Ask for a new input file path
                lineCount = 0; // Reset line count for the new file
            }
        }
        scanner.close();
    }

    // Task 2 from Lab 10: Count negatives and sum positives - kept for now, can be removed if not needed.
    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int negativeCount = 0;
        int positiveSum = 0;
        for (int num : input) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveSum += num;
            }
        }
        return new int[]{negativeCount, positiveSum};
    }
} 