package baekjoon.stepbystep.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class Q3273 {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int target = sc.nextInt();

        int result = 0;

        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                result++;
            }

            if (sum <= target) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }


}
