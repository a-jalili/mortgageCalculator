//import java.text.NumberFormat;
//import java.util.Date;
//import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        System.out.print("Principal?:");
//        Scanner sc = new Scanner(System.in);
//        int principal = sc.nextInt();
//        System.out.print("Annual Interest Rate?:");
//        float annualInterestRate = sc.nextFloat();
//        System.out.print("Period (Years)?:");
//        int period = sc.nextInt();
//        int numberOfPayments = period * 12;
//        double monthlyInterestRate = (annualInterestRate / 100) / 12;
//        double mortgage;
//        mortgage = principal * monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments) ) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
//        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        System.out.println(currency.format(mortgage));
//
//    }
//}

//import java.text.NumberFormat;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        final byte MONTHS_IN_YEAR = 12;
//        final byte PERCENTAGE = 100;
//
//        Scanner scanner = new Scanner(System.in);
//        int principal = 0;
//
//        while (true){
//            System.out.print("Principal ($1K - $1M) ?: ");
//            principal = scanner.nextInt();
//            if (principal < 1_000 || principal > 1_000_000){
//                System.out.println("Enter a number between $1K and $1M");
//            }else {
//                break;
//            }
//        }
//
//        float annualInterestRate;
//        while(true){
//            System.out.print("Annual Interest Rate (0+ - 30)%: ");
//            annualInterestRate = scanner.nextFloat();
//            if (annualInterestRate <= 0 || annualInterestRate > 30){
//                System.out.println("Enter a number greater than 0 and less or equal to 30");
//            }else {
//                break;
//            }
//        }
//
//        int years;
//        while (true) {
//            System.out.print("Period (1 - 30)Year(s)?: ");
//            years = scanner.nextInt();
//            if (years < 1 || years > 30){
//                System.out.println("Enter a number greater or equal to 1 and less or equal to 30");
//            }else {
//                break;
//            }
//        }
//        int totalPayments = years * MONTHS_IN_YEAR;
//        double monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_YEAR;
//
//        double mortgage = calculateMortgage(principal, monthlyInterestRate, totalPayments);
//
//        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
//        System.out.println("Your mortgage payment is: " + formattedMortgage);
//    }
//
//    private static double calculateMortgage(int principal, double monthlyInterestRate, int totalPayments) {
//        return principal *
//                monthlyInterestRate *
//                Math.pow(1 + monthlyInterestRate, totalPayments) /
//                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
//    }
//}

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        Scanner scanner = new Scanner(System.in);
        int principal = getInt(scanner, "Principal ($1K - $1M) ?: ", 1_000, 1_000_000);
        float annualInterestRate = getFloat(scanner, "Annual Interest Rate (0+ - 30)%: ", 0, 30);
        int years = getInt(scanner, "Period (1 - 30)Year(s)?: ", 1, 30);

        int totalPayments = years * MONTHS_IN_YEAR;
        double monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double mortgage = calculateMortgage(principal, monthlyInterestRate, totalPayments);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your mortgage payment is: " + formattedMortgage);
    }

    private static int getInt(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.println("Enter a number between " + min + " and " + max);
            } else {
                break;
            }
        }
        return value;
    }

    private static float getFloat(Scanner scanner, String prompt, float minExclusive, float max) {
        float value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value <= minExclusive || value > max) {
                System.out.println("Enter a number greater than " + minExclusive + " and less or equal to " + max);
            } else {
                break;
            }
        }
        return value;
    }

    private static double calculateMortgage(int principal, double monthlyInterestRate, int totalPayments) {
        return principal *
                monthlyInterestRate *
                Math.pow(1 + monthlyInterestRate, totalPayments) /
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
    }
}
