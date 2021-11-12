package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1011_solving {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 5

            // 1, 5
            // 처음과 마지막은 무조건 1칸
            // 남은거리의 시작점에 따라 출발점 값을 + 하거나 - 하거나 0 처리

            int distance = y-x;

            int count = 0;
            int max = (int) Math.sqrt(distance);

        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
