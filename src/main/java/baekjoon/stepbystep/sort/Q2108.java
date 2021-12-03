package baekjoon.stepbystep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //1. 평균 2. 중앙 3. 최빈 4. 범위
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int avg = (int) Math.round((double) Arrays.stream(arr).sum() / size);
        int mid = arr[(size-1) / 2];
        int freq = 0;
        int range = arr[size-1] - arr[0];

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        int max = Collections.max(map.values());
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max && cnt ==0) {
                freq = entry.getKey();
                cnt++;
            } else if (entry.getValue() == max && cnt == 1) {
                freq = entry.getKey();
                break;
            }
        }

        sb.append(avg).append("\n")
                .append(mid).append("\n")
                .append(freq).append("\n")
                .append(range);

        System.out.println(sb.toString());
    }
}
