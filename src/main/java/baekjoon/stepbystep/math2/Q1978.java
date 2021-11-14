package baekjoon.stepbystep.math2;

import java.util.Scanner;

public class Q1978 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] input = new int[size];
        int count = 0;
        out:for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();

            if(input[i]==1) continue;

            for (int j = 2; j < input[i]; j++) {
                if (input[i] % j == 0) {
                    continue out;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
