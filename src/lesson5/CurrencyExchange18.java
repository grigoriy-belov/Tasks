package lesson5;

import java.util.Arrays;

public class CurrencyExchange18 {
    public static void main(String[] args) {
        double[] exchangeRates = {24.95, 25.02, 24.99, 25.15, 25.3, 25.00};

        int numberOfBank = -1;
        double max = 0;

        for (int i = 0; i < exchangeRates.length; i++) {
            if (exchangeRates[i] > max) {
                max = exchangeRates[i];
                numberOfBank = i;
            }
        }

        System.out.println("Max exchange rate is in bank #" + numberOfBank);
    }
}
