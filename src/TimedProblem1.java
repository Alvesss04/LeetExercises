import java.util.ArrayList;
import java.util.List;

/**
 * TIMED PROBLEM: 40 minutes. Java. No hints unless you ask.
 *
 * Subarray Sum Count
 *
 * Given an array of integers nums and a target k, return the number of
 * contiguous, non-empty subarrays whose elements sum to exactly k.
 *
 * Constraints:
 *   1 <= nums.length <= 200,000
 *   -100,000 <= nums[i] <= 100,000    (values can be negative)
 *   -10^10 <= k <= 10^10
 *
 * Examples:
 *   nums = [1, 1, 1],   k = 2  ->  2   ([1,1] twice)
 *   nums = [1, 2, 3],   k = 3  ->  2   ([1,2] and [3])
 *   nums = [1, -1, 0],  k = 0  ->  3   ([1,-1], [0], [1,-1,0])
 *
 * Plan for the 40 minutes:
 *   0-5   read, list edge cases, choose the complexity from the constraints
 *   5-10  plan in comments
 *   10-30 code and run the examples
 *   30-40 test your own edge cases, then ask me for a review
 */
public class TimedProblem1 {

    /**
     * Prefix sums + hash map. O(n) time, O(n) space.
     *
     * A subarray (i..j] sums to k exactly when prefix[j] - prefix[i] == k,
     * i.e. prefix[i] == prefix[j] - k. So for each running sum we count how many
     * earlier prefixes equal (sum - k).
     * A sliding window does not work here because values can be negative.
     */
    static int countSubarrays(int[] nums, long k) {
        java.util.Map<Long, Integer> seen = new java.util.HashMap<>();
        seen.put(0L, 1);            // empty prefix, so subarrays starting at index 0 are counted
        long sum = 0;               // long: up to 200,000 * 100,000 overflows int
        int count = 0;
        for (int x : nums) {
            sum += x;
            count += seen.getOrDefault(sum - k, 0);
            seen.merge(sum, 1, Integer::sum);   // add AFTER counting, so a subarray is never empty
        }
        return count;
    }

    public static void main(String[] args) {
        check(countSubarrays(new int[]{1, 1, 1}, 2), 2);
        check(countSubarrays(new int[]{1, 2, 3}, 3), 2);
        check(countSubarrays(new int[]{1, -1, 0}, 0), 3);
        // edge cases
        check(countSubarrays(new int[]{1}, 1), 1);
        check(countSubarrays(new int[]{1}, 0), 0);
        check(countSubarrays(new int[]{0, 0, 0}, 0), 6);
        check(countSubarrays(new int[]{-1, -1, 1}, 0), 1);
        int[] big = new int[30000];
        java.util.Arrays.fill(big, 100000);
        check(countSubarrays(big, 3_000_000_000L), 1);   // needs long prefix sums
    }

    static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + "  expected=" + expected + " actual=" + actual);
    }
}
