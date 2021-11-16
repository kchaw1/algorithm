package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 원코드는 시간초과로 통과가 안되어
// https://st-lab.tistory.com/79 를 참고하였음.
public class Q1011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 5

            // 1, 5
            // 처음과 마지막은 무조건 1칸
            // 남은거리의 시작점에 따라 출발점 값을 + 하거나 - 하거나 0 처리

            int distance = y-x;

            int max = (int) Math.sqrt(distance);

            // distance의 루트값이 자연수로 딱 나누어 떨어지는 부분의 시동횟수 = 2 * max -1
            if (max == Math.sqrt(distance)) {
                result[i] = 2*max-1;
            }
            // max가 변하는 구간의 사이에서는 count가 2번씩 변하는 규칙성을 띄는데 첫번째 변하는 구간의 경우
            // 거리와 연관지어 수식을 만들면 distance <= max*max+max 일 경우 시동횟수 = 2 * max 이다.
            else if (distance <= max*max+max) {
                result[i] = 2*max;
            }
            // 위 두 조건을 제외하고 나머지는 이제 두번쨰 변하는 구간인데
            // 이경우 시동횟수 = 2*max+1이다 이는 else 로 표현 가능하다
            else {
                result[i] = 2*max+1;
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
