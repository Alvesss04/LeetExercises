import java.util.*;

/**
 * PROBLEM 20: Word Pattern  (time budget: 15 min)   [pattern: map, two-way match]
 *
 * Given a `pattern` string of letters and a string `s` of words separated by
 * single spaces, return true if `s` follows the pattern. "Follows" means a
 * one-to-one match: each pattern letter maps to exactly one word, and each
 * word maps back to exactly one pattern letter.
 *
 * Examples:
 *   pattern = "abba", s = "dog cat cat dog"  -> true
 *   pattern = "abba", s = "dog cat cat fish" -> false
 *   pattern = "aaaa", s = "dog cat cat dog"  -> false   (a can't be both dog and cat)
 *   pattern = "abba", s = "dog dog dog dog"  -> false   (dog can't be both a and b)
 *   pattern = "abc",  s = "b c"              -> false   (different lengths)
 *
 * Constraints:
 *   1 <= pattern.length() <= 300
 *   pattern consists of lowercase letters
 *   s consists of lowercase letters and single spaces, no leading or trailing space
 *
 * Hint to self: one direction of the match is not enough.
 *
 * Write your solution in wordPattern, then run main to check.
 */
public class Problem20 {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> letterToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            String mapped = letterToWord.get(c);
            if (mapped != null) {
                if (!mapped.equals(word)) return false;
            } else {
                if (!usedWords.add(word)) return false;
                letterToWord.put(c, word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        check(wordPattern("abba", "dog cat cat dog"), true);
        check(wordPattern("abba", "dog cat cat fish"), false);
        check(wordPattern("aaaa", "dog cat cat dog"), false);
        check(wordPattern("abba", "dog dog dog dog"), false);
        check(wordPattern("abc", "b c"), false);
    }

    private static void check(boolean actual, boolean expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
