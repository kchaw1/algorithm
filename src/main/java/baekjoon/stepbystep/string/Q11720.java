package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        String numbers = br.readLine();

        String[] arr = numbers.split("");

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= Integer.parseInt(arr[i]);
        }

        System.out.println(sum);
    }
}
