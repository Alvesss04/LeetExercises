import java.util.*;

/**
 * PROBLEM 10: Minimum Operations to Make Array Sum Divisible by K  (time budget: 10 min)
 *
 * You are given an integer array `nums` and an integer `k`. You can perform
 * the following operation any number of times:
 *   - Select an index i and replace nums[i] with nums[i] - 1.
 *
 * Return the minimum number of operations required to make the sum of the
 * array divisible by k.
 *
 * Examples:
 *   nums = [3, 9, 7], k = 5 -> 4
 *       (4 operations on nums[1] = 9 -> [3, 5, 7], sum 15 is divisible by 5)
 *   nums = [4, 1, 3], k = 4 -> 0
 *       (sum is 8, already divisible by 4)
 *   nums = [3, 2],    k = 6 -> 5
 *       (3 ops on nums[0] and 2 ops on nums[1] -> [0, 0], sum 0 is divisible by 6)
 *
 * Constraints:
 *   1 <= nums.length <= 1000
 *   1 <= nums[i] <= 1000
 *   1 <= k <= 100
 *
 * Write your solution in minOperations, then run main to check.
 */
public class Problem10 {

    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length;i++){
            sum+= nums[i];
        }
            return sum%k;


    }

    public static void main(String[] args) {
        check(minOperations(new int[]{3, 9, 7}, 5), 4);
        check(minOperations(new int[]{4, 1, 3}, 4), 0);
        check(minOperations(new int[]{3, 2}, 6), 5);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
        System.out.println(Math.abs(7-8));
    }
}
