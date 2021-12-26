package baekjoon.stepbystep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/124 참고
public class Q1003 {

    static Integer[][] store = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int a = Integer.parseInt(br.readLine());

            fibonacci(a);

            sb.append(store[a][0]).append(" ").append(store[a][1]).append("\n");
        }

        System.out.println(sb);
    }

    static Integer[] fibonacci(int n) {
        if(n==0) {
            store[n][0] = 1;
            store[n][1] = 0;
        } else if(n == 1) {
            store[n][0] = 0;
            store[n][1] = 1;
        } if (store[n][0] == null || store[n][1] == null) {
            store[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            store[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return store[n];
    }
}
