package baekjoon.greedy;

import java.util.Scanner;

public class Q2720 {

    static final int Q = 25;
    static final int D = 10;
    static final int N = 5;
    static final int P = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();

            sb.append(input / Q).append(" ");
            input = input % Q;
            sb.append(input / D).append(" ");
            input = input % D;
            sb.append(input / N).append(" ");
            input = input % N;
            sb.append(input / P);

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
