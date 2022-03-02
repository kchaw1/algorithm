package baekjoon.stepbystep.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class Q2470 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.parallelSort(arr);

        int start = 0;
        int end = arr.length-1;
        int sum = Math.abs(arr[start] + arr[end]);

        int[] result = {arr[start], arr[end]};

        while (start < end) {
            int pointer1 = Math.abs(arr[start++] + arr[end]);
            int pointer2 = Math.abs(arr[start] + arr[end--]);

            if (pointer1 <= pointer2) {
                start++;

                if (pointer1 < sum) {
                    sum = pointer1;
                    result[0] = arr[start];
                    result[1] = arr[end];
                }
            } else {
                end--;

                if (pointer2 < sum) {
                    sum = pointer2;
                    result[0] = arr[start];
                    result[1] = arr[end];
                }
            }


        }

        System.out.println(result[0] + " " + result[1]);
    }
}
