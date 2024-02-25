import java.util.ArrayList;

public class StockAnalyzer {

    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];
        for (float price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    // Main method for testing the implemented methods
    public static void main(String[] args) {
        float[] stockPricesArray = {10.5f, 11.2f, 12.8f, 10.5f, 13.2f, 10.5f, 11.8f, 12.5f, 11.5f, 10.8f};
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesArrayList.add(price);
        }

        System.out.println("Average Price: " + calculateAveragePrice(stockPricesArray));
        System.out.println("Maximum Price: " + findMaximumPrice(stockPricesArray));
        System.out.println("Occurrences of 10.5: " + countOccurrences(stockPricesArray, 10.5f));
        System.out.println("Cumulative Sum: " + computeCumulativeSum(stockPricesArrayList));
    }
}
