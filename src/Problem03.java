import java.util.*;

/**
 * PROBLEM 3: First Unique Character  (time budget: 10 min)
 *
 * Given a string `s` of lowercase English letters, return the index of the
 * first character that appears exactly once in the string.
 * If there is no such character, return -1.
 *
 * Examples:
 *   s = "leetcode"     -> 0    ('l' appears once)
 *   s = "loveleetcode" -> 2    ('v' is the first that appears once)
 *   s = "aabb"         -> -1
 *
 * Constraints:
 *   1 <= s.length() <= 10^5
 *   s consists of lowercase English letters only.
 *
 * Target: O(n) time.
 *
 * Write your solution in firstUnique, then run main to check.
 */
public class Problem03 {

    public static int firstUnique(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        check(firstUnique("leetcode"), 0);
        check(firstUnique("loveleetcode"), 2);
        check(firstUnique("aabb"), -1);
        check(firstUnique("z"), 0);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
