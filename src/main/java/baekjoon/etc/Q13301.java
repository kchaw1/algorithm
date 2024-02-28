package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13301 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        fibonacci(1);

        System.out.println(dp[dp.length-1] * 2 + (dp[dp.length - 1] + dp[dp.length - 2]) * 2);
    }

    public static void fibonacci(int i) {
        if (i == dp.length) {
            return;
        }

        if (i <= 2) {
            dp[i] = 1;
        } else {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        fibonacci(++i);
    }
}
