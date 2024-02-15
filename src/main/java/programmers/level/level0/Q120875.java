package programmers.level.level0;

import java.util.HashMap;
import java.util.Map;

public class Q120875 {
    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};

        System.out.println(Q120875.solution(dots));
    }

    public static int solution(int[][] dots) {
        int answer = 0;

        int idx = 1;

        while (idx < 4) {
            int[] remains = findRemainingNumbers(0, idx);
            float originTilt = getTilt(dots[0], dots[idx]);
            float remainTilt = getTilt(dots[remains[0]], dots[remains[1]]);

            if (originTilt == remainTilt) answer++;

            idx++;
        }

        return answer;
    }

    public static float getTilt(int[] arr1, int[] arr2) {
        int x = arr1[0];
        int y = arr1[1];
        int x2 = arr2[0];
        int y2 = arr2[1];

        return (float) (y - y2) / (float) (x - x2);
    }

    public static int[] findRemainingNumbers(int a, int b) {
        int[] remaining = new int[2];
        int index = 0;
        for (int i = 0; i <= 3; i++) {
            if (i != a && i != b) {
                remaining[index++] = i;
            }
        }
        return remaining;
    }
}
