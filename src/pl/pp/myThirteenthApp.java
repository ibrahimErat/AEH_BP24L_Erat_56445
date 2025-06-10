package pl.pp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class myThirteenthApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath;
        String outputFilePath;

        System.out.println("Enter the path to the input text file:");
        inputFilePath = scanner.nextLine();

        System.out.println("Enter the path to the output text file:");
        outputFilePath = scanner.nextLine();

        boolean fileProcessedSuccessfully = false;

        while (!fileProcessedSuccessfully) {
            int wordCount = 0;
            Map<String, Integer> wordOccurrences = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        if (!word.isEmpty()) {
                            wordCount++;
                            String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                            if (!cleanedWord.isEmpty()) {
                                wordOccurrences.put(cleanedWord, wordOccurrences.getOrDefault(cleanedWord, 0) + 1);
                            }
                        }
                    }
                }
                fileProcessedSuccessfully = true;

                System.out.println("The input file \"" + Paths.get(inputFilePath).getFileName() + "\" has " + wordCount + " words.");
                System.out.println("Word Occurrences:");
                wordOccurrences.forEach((word, count) -> System.out.println(word + ": " + count));


                try (FileWriter writer = new FileWriter(outputFilePath)) {
                    writer.write("Input File: " + Paths.get(inputFilePath).getFileName() + "\n");
                    writer.write("Total Word Count: " + wordCount + "\n\n");
                    writer.write("Word Occurrences:\n");
                    for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
                        writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                    }
                    System.out.println("Results saved to \"" + outputFilePath + "\"");
                } catch (IOException e) {
                    System.err.println("Error writing to the output file: " + e.getMessage());
                }

            } catch (FileNotFoundException e) {
                System.err.println("Error: Input file not found: " + inputFilePath);
                System.out.println("Please enter a valid path for the input text file:");
                inputFilePath = scanner.nextLine();
            } catch (IOException e) {
                System.err.println("Error reading the input file: " + e.getMessage());
                System.out.println("An error occurred. Please enter a valid path for the input text file:");
                inputFilePath = scanner.nextLine();
            }
        }
        scanner.close();
    }
} 