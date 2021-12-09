package baekjoon.stepbystep.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        int[] arr = new int[size];
        // 입력
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arr2 = arr.clone();
        Arrays.sort(arr2);

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            if(!map.containsKey(arr2[i])) {
                map.put(arr2[i], cnt++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i]));

            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
