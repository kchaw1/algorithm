package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 */
public class Q1931 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[][] time = new int[size][2];

        for (int i = 0; i < time.length; i++) {
            for (int j = 0; j < time[i].length; j++) {
                time[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < time.length; i++) {
            if (prevEndTime <= time[i][0]) {
                prevEndTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

/**
 * 11
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 */
