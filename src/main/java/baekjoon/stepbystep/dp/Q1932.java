package baekjoon.stepbystep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1932 {

    static int[][] arr;
    static Integer[][] dp;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());

        arr = new int[size][size];
        dp = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < size; i++) {
            dp[size-1][i] = arr[size-1][i];
        }

        System.out.println(find(0,0));
    }

    public static int find(int depth, int idx) {
        // 마지막행 도달시 값 리턴
        if(depth == size-1) return dp[depth][idx];

        // 널일 경우 재귀 실행
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }

        // 최종값 리턴
        return dp[depth][idx];
    }
}
