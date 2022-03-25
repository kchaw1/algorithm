package programmers.level.level2;

import java.util.Stack;

public class Q12973 {

    public static void main(String[] args) {

        System.out.println(solution("baabaa"));
    }

    public static int solution(String s) {
        Stack<String> stack = new Stack<>();

        String[] arr = s.split("");

        for (String value : arr) {
            if (!stack.isEmpty() && stack.peek().equals(value)) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
