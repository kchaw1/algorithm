package baekjoon.greedy;

import java.util.Scanner;

/**
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 *
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class Q11047 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int money = sc.nextInt();

        int[] moneyUnit = new int[size];

        for (int i = 0; i < moneyUnit.length; i++) {
            moneyUnit[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = moneyUnit.length-1; i >= 0; i--) {
            if (money / moneyUnit[i] != 0) {
                int digit = money/moneyUnit[i];
                money = money - (moneyUnit[i] * digit);
                result += digit;
            }
            if(money == 0) break;
        }

        System.out.println(result);

        sc.close();
    }
}
