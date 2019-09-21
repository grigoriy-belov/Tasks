package lesson4;

import java.util.Arrays;

public class TeslaStocks {
    public static void main(String[] args) {
        double[] stockPrices = {15, 12, 13, 10, 9, 5, 1};

        int dayOfPurchase = 0;
        int dayOfSale = 0;
        int minPriceDay = 0;
        double minPrice = stockPrices[0];
        double maxMargin = stockPrices[1] - stockPrices[0];
        double potentialMargin = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            potentialMargin = stockPrices[i] - minPrice;
            if (potentialMargin >= maxMargin) {
                maxMargin = potentialMargin;
                dayOfSale = i;
                dayOfPurchase = minPriceDay;
            }
            if (stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
                minPriceDay = i;
            }
        }

        System.out.printf("Day of purchase: %1$-5s Price: %2$.1f $", dayOfPurchase + 1, stockPrices[dayOfPurchase]);
        System.out.println();
        System.out.printf("Day of sale: %1$-9s Price: %2$.1f $", dayOfSale + 1, stockPrices[dayOfSale]);
        System.out.println();
        System.out.printf("Max margin: %1$.1f $", maxMargin);
    }
}
