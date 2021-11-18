package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        System.out.println(factorial(input));
    }

    public static int factorial(int a) {
        if (a == 0) {
            return 1;
        }
        return a * factorial(--a);
    }
}
