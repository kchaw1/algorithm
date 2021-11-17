package baekjoon.stepbystep.math2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4948 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input;
        List<Integer> results = new ArrayList<>();

        while (true) {
            input = Integer.parseInt(sc.nextLine());

            if(input == 0) break;

            int size = 2*input;
            int result = 0;

            boolean[] arr = new boolean[size + 1];

            arr[0] = arr[1] = true;

            for (int i = 0; i <= Math.sqrt(size); i++) {
                if (!arr[i]) {
                    for (int j = i*i; j <= size; j += i) {
                        arr[j] = true;
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i] && input < i) {
                    result++;
                }
            }

            results.add(result);
        }

        results.forEach(System.out::println);
    }
}
