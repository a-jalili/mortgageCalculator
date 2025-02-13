import java.util.Scanner;

public class GameFuzzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (or type 'exit' to quit):\t");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number % 15 == 0) {
                    System.out.println("Fuzzbuzz");
                } else if (number % 5 == 0) {
                    System.out.println("Fuzz");
                } else if (number % 3 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(number);
                }
            } else if (scanner.hasNext("exit")) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}