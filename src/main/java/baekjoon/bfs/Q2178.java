package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    static boolean[][] visited;
    static int[][] maze;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(maze[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;

                q.offer(new int[] {nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
