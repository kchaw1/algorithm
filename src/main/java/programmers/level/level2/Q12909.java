package programmers.level.level2;

import java.util.Stack;

public class Q12909 {
    public static void main(String[] args) {
        boolean result = solution("(()(");

        System.out.println(result);
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();
        if (arr[0] == ')') {
            return false;
        }

        for (char bracket : arr) {
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            }
        }
        return stack.isEmpty();
    }
}
