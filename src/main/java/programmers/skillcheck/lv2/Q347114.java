package programmers.skillcheck.lv2;

import java.util.*;

public class Q347114 {
    static boolean[][] isVisited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int count = 0;

        isVisited = new boolean[maps.length][maps[0].length];


        int result = bfs(0,0, maps);

        System.out.println(result);
    }

    public static int dfs(int x, int y, int[][] maps) {
        isVisited[x][y] = true;

        int n = maps[0].length;
        int m = maps.length;

        for(int i=0; i<dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextY >= m || nextX >= n
                    || maps[nextX][nextY] == 0 || isVisited[nextX][nextY]) continue;

            maps[nextX][nextY] = maps[x][y] + 1;
            if(nextX == n-1 && nextY ==m-1) {
                return maps[nextX][nextY];
            } else {
                dfs(nextX, nextY, maps);
            }
        }

        return maps[x][y];
    }

    static int bfs(int x, int y, int[][] maps) {
        isVisited[x][y] = true;
        int n = maps[0].length;
        int m = maps.length;

        Queue<int[]> q = new LinkedList<>();

        int result = Integer.MAX_VALUE;
        q.offer(new int[] {x,y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0
                    || nextY < 0
                    || nextY >= m
                    || nextX >= n
                    || maps[nextX][nextY] == 0 || isVisited[nextX][nextY]) continue;
                maps[nextX][nextY] = maps[nowX][nowY] + 1;

                isVisited[nextX][nextY] = true;
                q.offer(new int[]{nextX, nextY});
                if(nextX == n-1 && nextY ==m-1 && maps[nextX][nextY] < result) result = maps[nextX][nextY];
            }
        }
        return result;
    }
}
