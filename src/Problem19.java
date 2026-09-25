import java.util.*;

/**
 * PROBLEM 19: Intersection of Two Arrays  (time budget: 10 min)   [pattern: set]
 *
 * Given two integer arrays `nums1` and `nums2`, return an array of the values
 * that appear in BOTH arrays. Each value must appear only once in the result,
 * and the result may be in any order.
 *
 * Examples:
 *   nums1 = [1, 2, 2, 1],    nums2 = [2, 2]           -> [2]
 *   nums1 = [4, 9, 5],       nums2 = [9, 4, 9, 8, 4]  -> [4, 9]
 *   nums1 = [1, 2, 3],       nums2 = [4, 5]           -> []
 *
 * Constraints:
 *   1 <= nums1.length, nums2.length <= 100000
 *   0 <= nums[i] <= 1000000
 *
 * Target: O(n + m) time.
 *
 * Write your solution in intersection, then run main to check.
 */
public class Problem19 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> setres = new HashSet<>();
        for (int i = 0; i < nums1.length;i++){
            set1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++){
            if (set1.contains(nums2[j])) setres.add(nums2[j]);
        }
        int[] res = new int[setres.size()];
        int k = 0;
        for (int value : setres) {
            res[k++] = value;
        }
        return res;
    }

    public static void main(String[] args) {
        check(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2});
        check(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{4, 9});
        check(intersection(new int[]{1, 2, 3}, new int[]{4, 5}), new int[]{});
    }

    // Sorts the result first, so the order you return doesn't matter.
    private static void check(int[] actual, int[] expected) {
        int[] a = actual.clone();
        Arrays.sort(a);
        System.out.println((Arrays.equals(a, expected) ? "PASS" : "FAIL")
                + " expected=" + Arrays.toString(expected)
                + " actual=" + Arrays.toString(actual));
    }
}
