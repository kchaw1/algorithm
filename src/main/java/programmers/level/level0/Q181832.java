package programmers.level.level0;

import java.util.Arrays;

class Q181832 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(4)));
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int x = 0;
        int y = 0;
        String direction = "right";

        int num = 0;
        while (num < n * n) {
            num += 1;
            switch (direction) {
                case "right":
                    answer[y][x] = num;
                    if (x + 1 < n && answer[y][x+1] == 0) {
                        x += 1;
                    } else {
                        y += 1;
                        direction = "down";
                    }
                    break;
                case "down":
                    answer[y][x] = num;
                    if (y + 1 < n && answer[y+1][x] == 0) {
                        y += 1;
                    } else {
                        x -= 1;
                        direction = "left";
                    }
                    break;
                case "left":
                    answer[y][x] = num;
                    if (x - 1 > -1 && answer[y][x-1] == 0) {
                        x -= 1;
                    } else {
                        y -= 1;
                        direction = "up";
                    }
                    break;
                case "up":
                    answer[y][x] = num;
                    if (y - 1 > -1 && answer[y-1][x] == 0) {
                        y -= 1;
                    } else {
                        x += 1;
                        direction = "right";
                    }
                    break;
            }
        }

        return answer;
    }
}
