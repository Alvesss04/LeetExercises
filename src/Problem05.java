import java.util.*;

/**
 * PROBLEM 5: Best Time to Buy and Sell Stock  (time budget: 10 min)
 *
 * You are given an array `prices` where prices[i] is the price of a stock
 * on day i. You may buy on one day and sell on a LATER day (one transaction).
 * Return the maximum profit you can make. If no profit is possible, return 0.
 *
 * Examples:
 *   prices = [7, 1, 5, 3, 6, 4]  -> 5   (buy at 1, sell at 6)
 *   prices = [7, 6, 4, 3, 1]     -> 0   (prices only fall, don't trade)
 *   prices = [2, 4, 1]           -> 2   (buy at 2, sell at 4)
 *
 * Constraints:
 *   1 <= prices.length <= 10^5
 *   0 <= prices[i] <= 10^4
 *
 * Target: O(n) time, O(1) extra space.
 *
 * Write your solution in maxProfit, then run main to check.
 */
public class Problem05 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        check(maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        check(maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        check(maxProfit(new int[]{2, 4, 1}), 2);
        check(maxProfit(new int[]{5}), 0);
        check(maxProfit(new int[]{1, 2}), 1);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
