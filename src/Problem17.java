import java.util.*;

/**
 * PROBLEM 17: Longest Substring Without Repeating Characters  (time budget: 20 min)
 *                                                              [pattern: sliding window]
 *
 * Given a string `s`, return the length of the longest substring that
 * contains no repeated character. A substring is a contiguous part of `s`.
 *
 * Examples:
 *   s = "abcabcbb" -> 3   ("abc")
 *   s = "bbbbb"    -> 1   ("b")
 *   s = "pwwkew"   -> 3   ("wke"; note "pwke" is a subsequence, not a substring)
 *   s = ""         -> 0
 *   s = "abba"     -> 2   ("ab" or "ba")
 *
 * Constraints:
 *   0 <= s.length() <= 50000
 *   s consists of English letters, digits, symbols and spaces
 *
 * Difference from Problem 16: here the window size is NOT fixed. It grows
 * while the substring is valid and shrinks when a repeat appears.
 * Target: O(n) time.
 *
 * Write your solution in lengthOfLongestSubstring, then run main to check.
 */
public class Problem17 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int best = 0;
        for (int right = 0; right < s.length();right++){
            char c = s.charAt(right);

            while (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        check(lengthOfLongestSubstring("abcabcbb"), 3);
        check(lengthOfLongestSubstring("bbbbb"), 1);
        check(lengthOfLongestSubstring("pwwkew"), 3);
        check(lengthOfLongestSubstring(""), 0);
        check(lengthOfLongestSubstring("abba"), 2);
        check(lengthOfLongestSubstring("a"), 1);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
