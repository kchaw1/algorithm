package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());

        int[] road = new int[cityCount-1];
        int[] oil = new int[cityCount];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < oil.length; i++) {
            oil[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int minCost = oil[0];
        for (int i = 0; i < road.length; i++) {
            if (oil[i] < minCost) {
                minCost = oil[i];
            }
            sum += (minCost * road[i]);
        }

        System.out.println(sum);

        br.close();
    }
}
