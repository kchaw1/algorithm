package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 *
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 *
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 */
public class Q1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mathExpression = sc.nextLine();

        String[] arr = mathExpression.split("-");

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] split = arr[i].split("\\+");

            int sum = 0;
            for (int j = 0; j < split.length; j++) {
                sum += Integer.parseInt(split[j]);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
