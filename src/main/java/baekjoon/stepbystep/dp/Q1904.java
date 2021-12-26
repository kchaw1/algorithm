package baekjoon.stepbystep.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q1904 {
    static int[] dp = new int[1000001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (dp[n] == -1) {
            return dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 15746;
        }
        return dp[n];
    }
}
