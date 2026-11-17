import java.util.*;

/**
 * REVISION 4: Group Anagrams  (time budget: 12 min)   [pattern: hashmap with canonical key]
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
public class Revision4 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] counts = new char[26];                 // letter frequencies as the key: O(L), no sorting
            for (int i = 0; i < word.length(); i++) counts[word.charAt(i) - 'a']++;
            groups.computeIfAbsent(new String(counts), key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
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
