package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int nextPushValue = 1;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int pickTarget = Integer.parseInt(br.readLine());

            if (nextPushValue <= pickTarget) {
                for (int j = nextPushValue; j <= pickTarget; j++) {
                    stack.push(j);
                    sb.append("+");
                }
                nextPushValue = pickTarget + 1;
            }

            if (stack.peek() == pickTarget) {
                stack.pop();
                sb.append("-");
            } else if (stack.peek() > pickTarget) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        String result = String.join("\n", sb.toString().split(""));
        System.out.println(result);
    }
}
