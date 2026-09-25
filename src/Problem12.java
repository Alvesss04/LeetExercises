import java.util.*;

/**
 * PROBLEM 12: Two Sum  (time budget: 15 min)
 *
 * Given an integer array `nums` and an integer `target`, return the indices
 * of the two numbers that add up to `target`. Exactly one solution exists,
 * and you may not use the same element twice. Indices may be returned in
 * any order.
 *
 * Examples:
 *   nums = [2, 7, 11, 15], target = 9 -> [0, 1]
 *   nums = [3, 2, 4],      target = 6 -> [1, 2]
 *   nums = [3, 3],         target = 6 -> [0, 1]
 *
 * Constraints:
 *   2 <= nums.length <= 100000
 *   -10^9 <= nums[i] <= 10^9
 *   Aim for O(n) time.
 *
 * Write your solution in twoSum, then run main to check.
 */
public class Problem12 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer j = map.get(complement);
            if (j != null) return new int[]{j, i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        check(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        check(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        check(twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
    }

    private static void check(int[] actual, int[] expected) {
        int[] a = actual.clone();
        Arrays.sort(a);
        System.out.println((Arrays.equals(a, expected) ? "PASS" : "FAIL")
                + " expected=" + Arrays.toString(expected)
                + " actual=" + Arrays.toString(actual));
    }
}
