package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2514 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();

        List<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        String[] arr = nums.split(" ");

        int min = 0;
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = Integer.parseInt(arr[i]);

            if (list.isEmpty()) {
                sb.append(0).append(" ");
                list.add(val);
                min = val;
                continue;
            }

            min = Math.min(min, val);
            int diff = val - min;

            if (maxDiff < diff) {
                maxDiff = diff;
            }

            list.add(val);
            sb.append(maxDiff).append(" ");
        }

        System.out.println(sb);
    }
}
