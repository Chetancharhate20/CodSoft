package internship;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current currency code: ");
        String currentCurrency = scanner.nextLine();

        System.out.print("Enter the Currencu to be Converted: ");
        String targetCurrency = scanner.nextLine();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = getExchangeRate(currentCurrency, targetCurrency);

        if (exchangeRate != -1) {
            double convertedAmount = amount * exchangeRate;
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, currentCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Sorry, failed to convert.");
        }

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {

        return 1.25;
    }
}

