import java.util.*;

/**
 * PROBLEM 8: Merge Intervals  (time budget: 15 min)
 *
 * Given an array of intervals where intervals[i] = [start, end], merge all
 * overlapping intervals and return the non-overlapping intervals that cover
 * all the input intervals, sorted by start.
 *
 * Intervals that only touch at an endpoint count as overlapping
 * ([1,4] and [4,5] merge into [1,5]).
 *
 * Examples:
 *   [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
 *   [[1,4],[4,5]]                -> [[1,5]]
 *   [[1,4],[0,4]]                -> [[0,4]]      (input is NOT guaranteed sorted)
 *   [[1,4],[2,3]]                -> [[1,4]]      (one interval fully inside another)
 *
 * Constraints:
 *   1 <= intervals.length <= 10^4
 *   intervals[i].length == 2
 *   0 <= start <= end <= 10^4
 *
 * Target: O(n log n) time.
 *
 * Write your solution in merge, then run main to check.
 */
public class Problem08 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] cur : intervals) {
            if (result.isEmpty() || cur[0] > result.get(result.size() - 1)[1]) {
                result.add(cur);                       // no overlap: start a new interval
            } else {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], cur[1]);   // overlap: stretch the end
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        check(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
                new int[][]{{1, 6}, {8, 10}, {15, 18}});
        check(merge(new int[][]{{1, 4}, {4, 5}}), new int[][]{{1, 5}});
        check(merge(new int[][]{{1, 4}, {0, 4}}), new int[][]{{0, 4}});
        check(merge(new int[][]{{1, 4}, {2, 3}}), new int[][]{{1, 4}});
        check(merge(new int[][]{{5, 6}}), new int[][]{{5, 6}});
        check(merge(new int[][]{{8, 10}, {1, 3}, {2, 6}}), new int[][]{{1, 6}, {8, 10}});
    }

    private static void check(int[][] actual, int[][] expected) {
        System.out.println((Arrays.deepEquals(actual, expected) ? "PASS" : "FAIL")
                + " expected=" + Arrays.deepToString(expected)
                + " actual=" + Arrays.deepToString(actual));
    }
}
