package codeplus.algorithm.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                stack.push(num);
            } else if(command.equals("pop")) {
                list.add(stack.empty() ? -1 : stack.pop());
            } else if(command.equals("size")) {
                list.add(stack.size());
            } else if(command.equals("empty")) {
                list.add(stack.empty() ? 1 : 0);
            } else if(command.equals("top")) {
                list.add(stack.empty() ? -1 : stack.peek());
            }
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
