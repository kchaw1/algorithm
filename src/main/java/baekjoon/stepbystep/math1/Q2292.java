package baekjoon.stepbystep.math1;

import java.util.Scanner;

public class Q2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bee = sc.nextInt();

        int n = 0;
        while (true) {
            int a = 3*n*(n+1) + 1;

            if(a < bee) {
                n++;
            } else {
                break;
            }
        }

        System.out.println(n+1);
    }
}
