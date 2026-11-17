import java.util.*;

/**
 * REVISION 3: Merge Intervals  (time budget: 12 min)   [pattern: sort + sweep]
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
public class Revision3 {

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] out = new int[n][];
        int size = 0;
        int start = intervals[0][0], end = intervals[0][1];   // the interval being grown

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);          // overlap or touch: extend
            } else {
                out[size++] = new int[]{start, end};           // gap: close it, start a new one
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        out[size++] = new int[]{start, end};
        return Arrays.copyOf(out, size);
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
