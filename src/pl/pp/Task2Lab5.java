package pl.pp;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

public class Task2Lab5 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
            new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
            new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
            new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // Find student with highest average
        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
        System.out.printf("Student with the highest average: %s %s (%s) - Average: %.2f\n",
                topStudent.getFirstName(), topStudent.getLastName(), topStudent.getIndexNumber(), topStudent.getAverageGrade());

        // Sort students by last name
        students.sort(Comparator.comparing(Student::getLastName));
        System.out.println("Students sorted by last names:");
        for (Student s : students) {
            System.out.printf("%s %s (%s) - Average: %.2f\n",
                    s.getFirstName(), s.getLastName(), s.getIndexNumber(), s.getAverageGrade());
        }

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