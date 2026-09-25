import java.util.*;

/**
 * PROBLEM 13: Group Anagrams  (time budget: 20 min)
 *
 * Given an array of strings `words`, group the words that are anagrams of
 * each other. Groups and words within a group may be in any order.
 *
 * Examples:
 *   ["eat","tea","tan","ate","nat","bat"]
 *       -> [["eat","tea","ate"], ["tan","nat"], ["bat"]]
 *   [""]  -> [[""]]
 *   ["a"] -> [["a"]]
 *
 * Constraints:
 *   1 <= words.length <= 10000
 *   0 <= words[i].length() <= 100
 *   words[i] consists of lowercase English letters
 *
 * Write your solution in groupAnagrams, then run main to check.
 */
public class Problem13 {

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            String cur = new String(temp);
            map.computeIfAbsent(cur,k -> new ArrayList<>()).add(words[i]);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        check(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                "[[ate, eat, tea], [bat], [nat, tan]]");
        check(groupAnagrams(new String[]{""}), "[[]]");
        check(groupAnagrams(new String[]{"a"}), "[[a]]");
    }

    // Sorts words inside each group, then the groups, so order doesn't matter.
    private static void check(List<List<String>> actual, String expected) {
        List<String> groups = new ArrayList<>();
        for (List<String> g : actual) {
            List<String> copy = new ArrayList<>(g);
            Collections.sort(copy);
            groups.add(copy.toString());
        }
        Collections.sort(groups);
        String normalized = groups.toString();
        System.out.println((normalized.equals(expected) ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + normalized);
    }
}
