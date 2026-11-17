import java.util.*;

/**
 * REVISION 2: Valid Parentheses  (time budget: 8 min)   [pattern: stack]
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
public class Revision2 {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] stack = new char[s.length() / 2];   // never holds more than half the string
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> { if (top == stack.length) return false; stack[top++] = ')'; }
                case '[' -> { if (top == stack.length) return false; stack[top++] = ']'; }
                case '{' -> { if (top == stack.length) return false; stack[top++] = '}'; }
                default -> { if (top == 0 || stack[--top] != c) return false; }
            }
        }
        return top == 0;
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
