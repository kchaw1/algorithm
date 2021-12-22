package baekjoon.stepbystep.bruteforce;

import java.io.IOException;
import java.util.Scanner;

public class Q2798 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int targetNum = sc.nextInt();

        int[] cards = new int[size];
        for (int i = 0; i < size; i++) {
            cards[i] = sc.nextInt();
        }

        int result = 0;

        out:for (int i = 0; i < cards.length-2; i++) {
            for (int j = i+1; j < cards.length-1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if(sum == targetNum) {
                        result = sum;
                        break out;
                    }

                    if (targetNum > sum && sum > result) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
