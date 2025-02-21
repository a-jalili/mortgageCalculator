import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENTAGE = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M) ?: ", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate (0 - 30)%: ", 0, 30);
        byte years = (byte) readNumber("Period (1 - 30)Year(s)?: ", 1, 30);

        printMortgage(principal, annualInterestRate, years);
        printBalance(principal, annualInterestRate, years);
    }

    private static double readNumber(String prompt, int min, int max) {
        double value;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value < min || value > max) {
                System.out.println("Enter a number between " + min + " and " + max);
            } else {
                break;
            }
        }
        return value;
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        int totalPayments = years * MONTHS_IN_YEAR;
        double monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double mortgage = calculateMortgage(principal, monthlyInterestRate, totalPayments);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage:");
        System.out.println("-----------");
        System.out.println("Your mortgage payment is: " + formattedMortgage);
    }
    private static double calculateMortgage(int principal,
                                            double monthlyInterestRate,
                                            int totalPayments) {
        return principal *
                monthlyInterestRate *
                Math.pow(1 + monthlyInterestRate, totalPayments) /
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
    }

    private static void printBalance(int principal, float annualInterestRate, byte years) {
        int totalPayments = years * MONTHS_IN_YEAR;
        double monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_YEAR;
        double balance = 0;
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("------------------");
        for (short month = 1; month <= totalPayments; month++) {
            balance = calculateBalance(principal, monthlyInterestRate, totalPayments, month);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(formattedBalance);
        }
    }

    private static double calculateBalance(int principal,
                                           double monthlyInterestRate,
                                           int totalPayments,
                                           short numberOfPaymentsMade){
        double balance = principal *
                (Math.pow(1 + monthlyInterestRate, totalPayments) -
                        Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
        return balance;

    }
}
