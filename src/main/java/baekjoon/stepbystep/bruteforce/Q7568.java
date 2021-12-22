package baekjoon.stepbystep.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranks = new int[size];
        Arrays.fill(ranks, 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    ranks[i] = ranks[i] + 1;
                }
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            System.out.print(ranks[i]);
            if(i != ranks.length-1) {
                System.out.print(" ");
            }
        }
    }
}
