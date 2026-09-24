import java.util.*;

/**
 * PROBLEM 6: Valid Palindrome  (time budget: 10 min)
 *
 * A phrase is a palindrome if, after converting all uppercase letters to
 * lowercase and removing all non-alphanumeric characters, it reads the same
 * forward and backward. Alphanumeric = letters and digits.
 *
 * Given a string `s`, return true if it is a palindrome, false otherwise.
 *
 * Examples:
 *   s = "A man, a plan, a canal: Panama" -> true   ("amanaplanacanalpanama")
 *   s = "race a car"                     -> false  ("raceacar")
 *   s = " "                              -> true   (empty after cleaning)
 *
 * Constraints:
 *   1 <= s.length() <= 2 * 10^5
 *   s consists of printable ASCII characters.
 *
 * Target: O(n) time, O(1) extra space (no building a cleaned copy).
 *
 * Write your solution in isPalindrome, then run main to check.
 */
public class Problem06 {

    public static boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < cleaned.length(); i++){
            if( cleaned.charAt(i) != cleaned.charAt(cleaned.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        check(isPalindrome("A man, a plan, a canal: Panama"), true);
        check(isPalindrome("race a car"), false);
        check(isPalindrome(" "), true);
        check(isPalindrome("0P"), false);
        check(isPalindrome(".,"), true);
        check(isPalindrome("ab_a"), true);
    }

    private static void check(boolean actual, boolean expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
