package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2293 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.split(" ");

        int n = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[target]);
    }
}
