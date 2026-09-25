import java.util.*;

/**
 * PROBLEM 7: Longest Substring Without Repeating Characters  (time budget: 15 min)
 *
 * Given a string `s`, return the length of the longest substring that
 * contains no repeated characters. (A substring is contiguous.)
 *
 * Examples:
 *   s = "abcabcbb" -> 3   ("abc")
 *   s = "bbbbb"    -> 1   ("b")
 *   s = "pwwkew"   -> 3   ("wke"; note "pwke" is a subsequence, not a substring)
 *   s = ""         -> 0
 *
 * Constraints:
 *   0 <= s.length() <= 5 * 10^4
 *   s consists of English letters, digits, symbols and spaces.
 *
 * Target: O(n) time.
 *
 * Write your solution in lengthOfLongestSubstring, then run main to check.
 */
public class Problem07 {

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
        check(lengthOfLongestSubstring(" "), 1);
        check(lengthOfLongestSubstring("abba"), 2);
        check(lengthOfLongestSubstring("dvdf"), 3);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
