package baekjoon.stepbystep.bruteforce;

import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        System.out.println(getConstructorNum(target));
    }

    public static int getConstructorNum(int target) {
        for (int i = 0; i < target; i++) {
            String s = String.valueOf(i);

            String[] split = s.split("");

            int sum = i;
            for (int j = 0; j < split.length; j++) {
                sum += Integer.parseInt(split[j]);
            }

            if (sum == target) {
                return i;
            }
        }
        return 0;
    }
}
