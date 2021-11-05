package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q13305_solving {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());

        int[] road = new int[cityCount-1];
        int[] oil = new int[cityCount];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < road.length; j++) {
            road[j] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < oil.length; j++) {
            oil[j] = Integer.parseInt(st2.nextToken());
        }


    }
}
