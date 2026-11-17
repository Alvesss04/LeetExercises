import java.util.*;

/**
 * REVISION 5: Longest Consecutive Sequence  (time budget: 15 min)   [pattern: hashset, sequence starts]
 *
 * Given an unsorted integer array `nums`, return the length of the longest
 * run of consecutive integers that can be formed from its values. The values
 * do NOT need to be next to each other in the array.
 *
 * Examples:
 *   nums = [100, 4, 200, 1, 3, 2]          -> 4   (1, 2, 3, 4)
 *   nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]  -> 9   (0 through 8)
 *   nums = [1, 2, 0, 1]                    -> 3   (0, 1, 2; duplicates don't count twice)
 *   nums = []                              -> 0
 *
 * Constraints:
 *   0 <= nums.length <= 100000
 *   -10^9 <= nums[i] <= 10^9
 *
 * Target: O(n) time. Sorting first would be O(n log n), which is a valid
 * first answer but not the best one.
 *
 * Write your solution in longestConsecutive, then run main to check.
 */
public class Revision5 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>(nums.length * 2);
        for (int x : nums) values.add(x);

        int best = 0;
        for (int x : values) {
            if (values.contains(x - 1)) continue;         // not the start of a run; skip so each run is walked once

            int end = x;
            while (values.contains(end + 1)) end++;
            best = Math.max(best, end - x + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        check(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4);
        check(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}), 9);
        check(longestConsecutive(new int[]{1, 2, 0, 1}), 3);
        check(longestConsecutive(new int[]{}), 0);
        check(longestConsecutive(new int[]{5}), 1);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
