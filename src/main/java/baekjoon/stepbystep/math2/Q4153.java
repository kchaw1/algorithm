package baekjoon.stepbystep.math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4153 {

    static int[] triangle = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            triangle[0] = Integer.parseInt(st.nextToken());
            triangle[1] = Integer.parseInt(st.nextToken());
            triangle[2] = Integer.parseInt(st.nextToken());

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                break;
            }

            Arrays.sort(triangle);

            if (triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2]*triangle[2]) {
                sb.append("right \n");
            } else {
                sb.append("wrong \n");
            }
        }

        System.out.println(sb.toString());
    }
}
