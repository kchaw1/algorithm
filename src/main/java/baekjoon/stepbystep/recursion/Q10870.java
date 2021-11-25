package baekjoon.stepbystep.recursion;

import java.util.*;

public class Q10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        System.out.println(fibonacci(input));
    }

    public static int fibonacci(int input) {
        if (input <= 1) {
            return input;
        }
        return fibonacci(input-2) + fibonacci(input-1);
    }
}
