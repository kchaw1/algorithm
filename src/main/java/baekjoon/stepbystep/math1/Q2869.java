package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken()); // 올라가는
        int fall = Integer.parseInt(st.nextToken()); // 떨어지는
        int height = Integer.parseInt(st.nextToken()); // 나무높이

        int day = (height-fall) / (up-fall);
        if((height-fall) % (up-fall) != 0) {
            day++;
        }

        System.out.println(day);
    }
}
