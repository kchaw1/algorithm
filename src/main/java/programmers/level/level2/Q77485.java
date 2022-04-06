package programmers.level.level2;

import java.util.Arrays;

public class Q77485 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        System.out.println(Arrays.toString(solution(rows,columns,queries)));
    }

    static int[][] arr;
    static int min;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        answer = new int[queries.length];
        arr = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int i=0; i< queries.length; i++) {
            min = Integer.MAX_VALUE;
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public static int rotate(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int idx = 0;
        int tmp = arr[x1][y1];

        int currX = x1;
        int currY = y1;

        while(idx < 4) {
            int nextX = currX + dx[idx];
            int nextY = currY + dy[idx];

            if (nextX > x2 || nextX < x1 || nextY < y1 || nextY > y2) {
                idx++;
            } else {
                arr[currX][currY] = arr[nextX][nextY];
                min = Math.min(min, arr[currX][currY]);
                currX = nextX;
                currY = nextY;
            }
        }

        arr[currX][currY + 1] = tmp;

        min = Math.min(min, arr[currX][currY + 1]);

        return min;
    }
}
