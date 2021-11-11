package baekjoon.stepbystep.math1;

import java.util.Scanner;

public class Q1193 {
    public static void main(String[] args) {

        // 내 풀이 x, y가 각각 1 각각 짝수 또는 홀수일때의 규칙으로 한칸씩 이동. 비효율적인것 같다.
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        // x/y
        int x = 1;
        int y = 1;
        int count = 1;
        boolean flag = true;

        while (count < i) {
            if(x==1 && y % 2 == 1) { // x 가 1이고 y가 홀수인경우
                y++;
            } else if (x == 1 && y % 2 == 0) { // x가 1이고 y가 짝수인경우
                x++;
                y--;
                flag = true;
            } else if (x % 2 == 0 && y == 1) { // x가 짝수고 y가 1인경우
                x++;
            } else if (x % 2 == 1 && y == 1) { // x가 홀수고 y가 1인경우
                x--;
                y++;
                flag = false;
            } else {
                if (flag) {
                    x++;
                    y--;
                } else {
                    x--;
                    y++;
                }
            }

            count++;
        }

        System.out.println(x + "/" + y);

        // st-lab 티스토리 블로그의 풀이. 주어진 배열을 대각선으로 보는게 핵심이다.
        // 입력값을 기존 대각원소의 개수의 누적합 + 현재대각원소의 개수를 기준으로
        // 몇번째 대각선에 있는지 찾은 후
        // 해당 대각칸의 개수가 짝수(좌하향) 홀수(우상향) 인지에 따라 방향을 결정하고
        // 방향에따라 입력값 - 이전대각선누적합
        // 현재 대각선 칸의 개수 - ( 입력값 - 이전대각선누적합) + 1
        // 을 분모 분자로 배치하여 결과를 도출한다.

        /*Scanner in = new Scanner(System.in);
        int X = in.nextInt();

        int cross_count = 1, prev_count_sum = 0;

        while (true) {

            // 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
            if (X <= prev_count_sum + cross_count) {

                if (cross_count % 2 == 1) {	// 대각선의 개수가 홀수라면
                    // 분모가 큰 수부터 시작
                    // 분모는 대각선 개수 - (X 번째 - 직전 대각선까지의 누적합 - 1)
                    // 분자는 X 번째 - 직전 대각선까지의 누적합
                    System.out.print((cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
                    break;
                }

                else {	// 대각선의 개수가 짝수라면
                    // 홀수일 때의 출력을 반대로
                    System.out.print((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
                    break;
                }

            } else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        }*/
    }
}
