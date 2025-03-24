package pl.pp;

import java.util.Scanner;

public class mySecondApp {
    public static void main(String[] args) {
        double x = 10; // creating a double type variable and assigning it a value of 10
        double y = 2;

        Scanner scanner = new Scanner(System.in);

        var result = x + y;
        System.out.println("x + y = " + result);

        result = x - y;
        System.out.println("x - y = " + result);

        result = x * y;
        System.out.println("x * y = " + result);

        result = x / y;
        System.out.println("x / y = " + result);

        result = x % y;
        System.out.println("x % y = " + result);

        System.out.println("Enter two numbers separated by the Enter key:");
        double first = scanner.nextDouble(); // request to enter a double value
        double second = scanner.nextDouble();

        System.out.println("x + y = " + (first + second));
    }
} 