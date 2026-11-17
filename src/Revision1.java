import java.util.*;

/**
 * REVISION 1: Pairs With Given Difference  (time budget: 15 min)   [pattern: hashset]
 *
 * Given an array of integers `arr` and an integer `k`, return the number of
 * unique pairs (a, b) such that a - b == k, where a and b are values from the array.
 * Pairs are counted by value, not by index: each distinct (a, b) counts once.
 *
 * Examples:
 *   arr = [1, 5, 3, 4, 2], k = 2      -> 3   ((3,1), (5,3), (4,2))
 *   arr = [1, 1, 1, 2, 2], k = 1      -> 1   ((2,1))
 *   arr = [1, 2, 3], k = 0            -> 3   ((1,1), (2,2), (3,3))  a value pairs with itself when k == 0
 *   arr = [], k = 5                   -> 0
 *
 * Constraints:
 *   0 <= arr.length <= 10^5
 *   -10^9 <= arr[i] <= 10^9
 *   0 <= k <= 10^9
 *
 * Target: better than O(n^2).
 *
 * Write your solution in countPairs, then run main to check.
 */
public class Revision1 {

    public static int countPairs(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }

        for (int x : set){
            if (set.contains(x - k)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        check(countPairs(new int[]{1, 5, 3, 4, 2}, 2), 3);
        check(countPairs(new int[]{1, 1, 1, 2, 2}, 1), 1);
        check(countPairs(new int[]{1, 2, 3}, 0), 3);
        check(countPairs(new int[]{1, 1, 2}, 0), 2);
        check(countPairs(new int[]{}, 5), 0);
        check(countPairs(new int[]{1_000_000_000, -1_000_000_000}, 1_000_000_000), 0);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected + " actual=" + actual);
    }
}
