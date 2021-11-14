package baekjoon.stepbystep.math2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        List<Integer> primes = new ArrayList<>();

        out:for (int i = num1; i <= num2; i++) {
            if (i == 1) {
                continue ;
            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue out;
                }
            }

            primes.add(i);
        }

        if (primes.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(primes.stream().reduce(0, Integer::sum));
            System.out.println(primes.get(0));
        }
    }
}
