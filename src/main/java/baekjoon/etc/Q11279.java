package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    Integer max = maxHeap.poll();
                    sb.append(max).append("\n");
                }
            } else {
                maxHeap.add(num);
            }
        }

        System.out.println(sb);
    }
}
