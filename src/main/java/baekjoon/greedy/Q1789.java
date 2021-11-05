package baekjoon.greedy;

import java.util.*;

/**
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 */
public class Q1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long naturalNumber = sc.nextLong();
        long sum = 0L;

        for (long i = 1; ; i++) {
            sum += i;
            if (sum > naturalNumber) {
                System.out.println(i-1);
                break;
            }
        }
        sc.close();
    }
}
