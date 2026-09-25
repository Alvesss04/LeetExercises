import java.util.*;

/**
 * PROBLEM 16: Maximum Sum of a Subarray of Size K  (time budget: 12 min)
 *                                                    [pattern: sliding window]
 *
 * Given an integer array `nums` and an integer `k`, return the maximum sum
 * of any contiguous subarray of exactly `k` elements.
 *
 * Examples:
 *   nums = [2, 1, 5, 1, 3, 2], k = 3 -> 9     (subarray [5, 1, 3])
 *   nums = [2, 3, 4, 1, 5],    k = 2 -> 7     (subarray [3, 4])
 *   nums = [-1, -2, -3],       k = 2 -> -3    (subarray [-1, -2])
 *   nums = [4, 4],             k = 2 -> 8
 *
 * Constraints:
 *   1 <= k <= nums.length <= 100000
 *   -10000 <= nums[i] <= 10000
 *
 * Target: O(n) time. Recomputing each window's sum from scratch is O(n * k).
 *
 * Write your solution in maxSum, then run main to check.
 */
public class Problem16 {

    public static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int best = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            best = Math.max(best, windowSum);
        }
        return best;
    }

    public static void main(String[] args) {
        check(maxSum(new int[]{2, 1, 5, 1, 3, 2}, 3), 9);
        check(maxSum(new int[]{2, 3, 4, 1, 5}, 2), 7);
        check(maxSum(new int[]{-1, -2, -3}, 2), -3);
        check(maxSum(new int[]{4, 4}, 2), 8);
        check(maxSum(new int[]{7}, 1), 7);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
