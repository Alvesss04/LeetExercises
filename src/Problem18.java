import java.util.*;

/**
 * PROBLEM 18: Maximum Vowels in a Substring of Length K  (time budget: 10 min)
 *                                                         [pattern: sliding window]
 *
 * Given a string `s` and an integer `k`, return the maximum number of vowel
 * letters (a, e, i, o, u) in any substring of `s` with length exactly `k`.
 *
 * Examples:
 *   s = "abciiidef", k = 3 -> 3   ("iii")
 *   s = "aeiou",     k = 2 -> 2   ("ae", "ei", "io" or "ou")
 *   s = "leetcode",  k = 3 -> 2   ("lee", "eet" or "ode")
 *   s = "rhythm",    k = 4 -> 0   (no vowels at all)
 *
 * Constraints:
 *   1 <= k <= s.length() <= 100000
 *   s consists of lowercase English letters
 *
 * Target: O(n) time. Same idea as Problem 16, but the window tracks a
 * vowel count instead of a sum.
 *
 * Write your solution in maxVowels, then run main to check.
 */
public class Problem18 {

    public static int maxVowels(String s, int k) {

        return -1;
    }

    public static void main(String[] args) {
        check(maxVowels("abciiidef", 3), 3);
        check(maxVowels("aeiou", 2), 2);
        check(maxVowels("leetcode", 3), 2);
        check(maxVowels("rhythm", 4), 0);
        check(maxVowels("a", 1), 1);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
