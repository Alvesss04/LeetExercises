import java.util.*;

/**
 * PROBLEM 15: Valid Palindrome  (time budget: 10 min)   [pattern: two pointers]
 *
 * A phrase is a palindrome if, after converting all uppercase letters to
 * lowercase and removing every character that is not a letter or a digit,
 * it reads the same forwards and backwards.
 * Given a string `s`, return true if it is a palindrome, otherwise false.
 *
 * Examples:
 *   s = "A man, a plan, a canal: Panama" -> true   ("amanaplanacanalpanama")
 *   s = "race a car"                     -> false  ("raceacar")
 *   s = " "                              -> true   (empty after cleaning)
 *   s = "0P"                             -> false
 *
 * Constraints:
 *   1 <= s.length() <= 200000
 *   s consists of printable ASCII characters
 *
 * Stretch goal: O(n) time and O(1) extra space (no cleaned copy of the string).
 *
 * Write your solution in isPalindrome, then run main to check.
 */
public class Problem15 {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        check(isPalindrome("A man, a plan, a canal: Panama"), true);
        check(isPalindrome("race a car"), false);
        check(isPalindrome(" "), true);
        check(isPalindrome("0P"), false);
        check(isPalindrome("ab_a"), true);
    }

    private static void check(boolean actual, boolean expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
