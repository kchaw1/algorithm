package baekjoon.stepbystep.math2;

import java.util.Scanner;

public class Q11653 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int start = 2;
        while (num != 1) {
            if (num % start == 0) {
                num /= start;
                System.out.println(start);
            } else {
                start++;
            }
        }
    }
}
