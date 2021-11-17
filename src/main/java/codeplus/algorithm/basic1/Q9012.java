package codeplus.algorithm.basic1;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        String[] result = new String[size];

        out:for (int i = 0; i < size; i++) {
            String s = sc.nextLine();

            String[] arr = s.split("");

            Stack<String> stack = new Stack<>();

            for (int j = 0; j < arr.length; j++) {
                 if(stack.empty() && arr[j].equals(")")) { // 처음과 마지막 먼저 검사
                     result[i] = "NO";
                     continue out;
                 }

                if(arr[j].equals(")")) {
                    stack.pop();
                } else {
                    stack.push(arr[j]);
                }
            }

            if(stack.size() == 0) {
                result[i] = "YES";
            } else {
                result[i] = "NO";
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
