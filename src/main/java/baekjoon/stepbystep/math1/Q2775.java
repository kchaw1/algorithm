package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 맞긴했지만 3중 for문을 사용 어거지로 푼거같다.. 내일다시 점검
public class Q2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), "");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), "");

            int floor = Integer.parseInt(st1.nextToken());
            int ho = Integer.parseInt(st2.nextToken());

            int[][] apart = new int[floor+1][ho];

            for (int j = 0; j < apart.length; j++) { // 층
                apart[j][0] = 1;
                for (int k = 1; k < apart[j].length; k++) { // 호
                    if (j == 0) {
                        apart[j][k] = k+1;
                    } else {
                        int sum=0;
                        for (int l = 0; l <= k; l++) {
                            sum += apart[j - 1][l];
                        }
                        apart[j][k] = sum;
                    }
                }
            }
            result[i] = apart[floor][ho-1];
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
