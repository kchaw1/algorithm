package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
 *
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 *
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 */
public class Q1912 {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n];
        String[] arr = br.readLine().split(" ");
        dp[0] = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Integer num = Integer.parseInt(arr[i]);
            dp[i] = Math.max(dp[i - 1] + num, num);
        }

        System.out.println(Arrays.stream(dp).max(Integer::compareTo).get());
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] arr = br.readLine().split(" ");
//
//        int unit = 1;
//        int idx = 0;
//        int max = Integer.MIN_VALUE;
//        while (unit < arr.length) {
//            int sum = 0;
//            for (int i = idx; i < idx+unit; i++) {
//                sum += Integer.parseInt(arr[i]);
//            }
//
//            if (sum > max) {
//                max = sum;
//            }
//
//            if (idx + unit == arr.length) {
//                unit++;
//                idx = 0;
//            } else {
//                idx++;
//            }
//        }
//
//        System.out.println(max);
//    }
}
