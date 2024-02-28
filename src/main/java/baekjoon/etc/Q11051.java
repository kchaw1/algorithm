package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q11051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] arr = s.split(" ");

        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        BigInteger num1 = factorial(n);
        BigInteger num2 = factorial(k).multiply(factorial(n - k));

        BigInteger divide = num1.divide(num2).mod(BigInteger.valueOf(10007));

        System.out.println(divide);
    }

    public static BigInteger factorial(int n) {
        BigInteger accumulate = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            accumulate = accumulate.multiply(BigInteger.valueOf(i));
        }
        return accumulate;
    }
}
