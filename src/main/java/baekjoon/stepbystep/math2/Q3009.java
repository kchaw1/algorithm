package baekjoon.stepbystep.math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3009 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] rec = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            rec[i][0] = x;
            rec[i][1] = y;
        }

        int resultX = 0;
        int resultY = 0;
        for (int i = 0; i < rec.length; i++) {
            int x = rec[i][0];
            int y = rec[i][1];

            boolean isX = false;
            boolean isY = false;
            for (int j = 0; j < rec.length; j++) {
                if(i==j) continue;

                if (x == rec[j][0]) {
                    isX = true;
                }
                if (y == rec[j][1]) {
                    isY = true;
                }
            }

            if(!isX) {
                resultX = x;
            }
            if(!isY) {
                resultY = y;
            }
        }

        System.out.println(resultX + " " + resultY);
    }
}
