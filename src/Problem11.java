import java.util.*;

/**
 * PROBLEM 11: First Unique Character  (time budget: 10 min)
 *
 * Given a string `s`, return the index of the first character that appears
 * exactly once in the string. If there is none, return -1.
 *
 * Examples:
 *   s = "leetcode"     -> 0   ('l' appears once)
 *   s = "loveleetcode" -> 2   ('v' is the first unique char)
 *   s = "aabb"         -> -1
 *
 * Constraints:
 *   1 <= s.length() <= 100000
 *   s consists of lowercase English letters
 *
 * Write your solution in firstUniqChar, then run main to check.
 */
public class Problem11 {

    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int j = 0; j < s.length();j++){
            if (map.get(s.charAt(j)) == 1) return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        check(firstUniqChar("leetcode"), 0);
        check(firstUniqChar("loveleetcode"), 2);
        check(firstUniqChar("aabb"), -1);
        check(firstUniqChar("z"), 0);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
