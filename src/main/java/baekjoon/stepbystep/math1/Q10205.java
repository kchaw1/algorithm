package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] result = new int[size];

        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int guest = Integer.parseInt(st.nextToken());

            int[][] arr = new int[w][h];

            int idx = 0;
            out:for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    int ho = ((k+1)*100) + (j+1);
                    arr[j][k] = ho;

                    idx++;

                    if (idx == guest) {
                        result[i] = ho;
                        break out;
                    }
                }
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
