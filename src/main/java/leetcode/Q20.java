package leetcode;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char peek = stack.peek();
            if (peek == '(' && c == ')' || peek == '{' && c == '}' || peek == '[' && c == ']') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
