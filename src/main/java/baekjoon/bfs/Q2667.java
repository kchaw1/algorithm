package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {

    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] || map[i][j] == 0) continue;
                result.add(bfs(i, j));
            }
        }

        System.out.println(result.size());

        result.sort(Integer::compareTo);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startX, startY});

        int val = 1;

        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                val++;
            }
        }

        return val;
    }
}
