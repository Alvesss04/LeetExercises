import java.util.*;

/**
 * PROBLEM 9: Group Anagrams  (time budget: 15 min)
 *
 * Given an array of strings `strs`, group the anagrams together. You may
 * return the groups in any order, and the words inside a group in any order.
 * (An anagram uses exactly the same letters with the same counts.)
 *
 * Examples:
 *   ["eat","tea","tan","ate","nat","bat"]
 *       -> [["bat"], ["nat","tan"], ["ate","eat","tea"]]   (any order)
 *   [""]  -> [[""]]
 *   ["a"] -> [["a"]]
 *
 * Constraints:
 *   1 <= strs.length <= 10^4
 *   0 <= strs[i].length() <= 100
 *   strs[i] consists of lowercase English letters.
 *
 * Target: better than comparing every pair of words (O(n^2)).
 *
 * Write your solution in groupAnagrams, then run main to check.
 */
public class Problem09 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        check(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")));
        check(groupAnagrams(new String[]{""}), List.of(List.of("")));
        check(groupAnagrams(new String[]{"a"}), List.of(List.of("a")));
        check(groupAnagrams(new String[]{"ab", "ba", "abc", "cab", "c"}),
                List.of(List.of("ab", "ba"), List.of("abc", "cab"), List.of("c")));
    }

    // Order-insensitive comparison: sort words inside each group, then sort the groups.
    private static List<String> normalize(List<List<String>> groups) {
        List<String> out = new ArrayList<>();
        for (List<String> g : groups) {
            List<String> copy = new ArrayList<>(g);
            Collections.sort(copy);
            out.add(copy.toString());
        }
        Collections.sort(out);
        return out;
    }

    private static void check(List<List<String>> actual, List<List<String>> expected) {
        System.out.println((normalize(actual).equals(normalize(expected)) ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
