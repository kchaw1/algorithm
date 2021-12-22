package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1012 {

    static int[][] map;
    static boolean[][] visited;
    static int T; //테스트케이스
    static int N; //가로
    static int M; //세로
    static int K; //배추갯수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (visited[k][l] || map[k][l] == 0) continue;

                    list.add(bfs(k,l));
                }
            }
            sb.append(list.size());

            if(i != T -1) sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        int result = 1;

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                result++;
            }
        }

        return result;
    }
}
