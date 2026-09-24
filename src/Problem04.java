import java.util.*;

/**
 * PROBLEM 4: Valid Parentheses  (time budget: 10 min)
 *
 * Given a string `s` containing only the characters '(', ')', '{', '}',
 * '[' and ']', return true if the brackets are valid, false otherwise.
 *
 * A string is valid if:
 *   - every opening bracket is closed by the same type of bracket, and
 *   - brackets are closed in the correct order.
 *
 * Examples:
 *   s = "()"       -> true
 *   s = "()[]{}"   -> true
 *   s = "(]"       -> false
 *   s = "([)]"     -> false
 *   s = "{[]}"     -> true
 *
 * Constraints:
 *   1 <= s.length() <= 10^4
 *
 * Target: O(n) time.
 *
 * Write your solution in isValid, then run main to check.
 */
public class Problem04 {

    public static boolean isValid(String s) {
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
          if (pairs.containsKey(c)){
              if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) return false;
          }else{
              stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        check(isValid("()"), true);
        check(isValid("()[]{}"), true);
        check(isValid("(]"), false);
        check(isValid("([)]"), false);
        check(isValid("{[]}"), true);
        check(isValid("("), false);
        check(isValid("]"), false);
    }

    private static void check(boolean actual, boolean expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
