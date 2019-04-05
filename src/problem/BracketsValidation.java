package problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效括号的识别
 */
public class BracketsValidation {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || !isPattern(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPattern(char c1, char c2) {
        return c1 == '(' && c2 == ')'
                || c1 == '[' && c2 == ']'
                || c1 == '{' && c2 == '}';
    }
}
