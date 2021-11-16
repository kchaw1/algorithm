package baekjoon.stepbystep.math2;

import java.util.Scanner;

public class Q1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        printPrimeNumber(num1, num2);
    }

    // 에라토스테네스의 체
    public static void printPrimeNumber(int num1, int num2) {
        boolean[] arr = new boolean[num2 + 1]; // java boolean 배열의 초기값은 false

        // 0과 1은 소수가 아님
        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(num2); i++) { // 제곱근까지만 반복
            if (!arr[i]) { // 기존에서 걸러진 수들의 배수는 찾지 않는다
                for (int j = i * i; j<=num2;  j+=i) { // i*i 는 이미 걸러져서 시작값을 i*i로 최적화 할수 있다.
                    arr[j] = true;
                }
            }
        }

        for (int i = 2; i <= num2; i++) {
            if (!arr[i] && num1 <= i) {
                System.out.println(i);
            }
        }
    }
}
