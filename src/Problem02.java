import java.util.*;

/**
 * PROBLEM 2: Two Sum  (time budget: 15 min)
 *
 * Given an array of integers `nums` and an integer `target`, return the
 * indices of the two numbers such that they add up to `target`.
 *
 * Assume exactly one valid answer exists, and you may not use the same
 * element twice. Return the indices in any order.
 *
 * Examples:
 *   nums = [2, 7, 11, 15], target = 9   -> [0, 1]   (2 + 7 == 9)
 *   nums = [3, 2, 4],      target = 6   -> [1, 2]   (2 + 4 == 6)
 *   nums = [3, 3],         target = 6   -> [0, 1]   (3 + 3 == 6)
 *
 * Constraints:
 *   2 <= nums.length <= 10^4
 *   -10^9 <= nums[i], target <= 10^9
 *
 * Target: better than O(n^2).
 *
 * Write your solution in twoSum, then run main to check.
 */
public class Problem02 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        check(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        check(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        check(twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
    }

    private static void check(int[] actual, int[] expectedUnordered) {
        boolean pass = actual != null
                && actual.length == 2
                && Set.of(actual[0], actual[1]).equals(Set.of(expectedUnordered[0], expectedUnordered[1]));
        System.out.println((pass ? "PASS" : "FAIL")
                + " expected=" + Arrays.toString(expectedUnordered)
                + " actual=" + Arrays.toString(actual));
    }
}
