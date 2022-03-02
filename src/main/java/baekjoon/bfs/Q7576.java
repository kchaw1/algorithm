package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {

    static int M;
    static int N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();

        StringTokenizer st = new StringTokenizer(size, " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        out:for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    result = -1;
                    break out;
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new int[] {i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int day = poll[2];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || N <= nextX || nextY < 0 || M <= nextY
                        || box[nextX][nextY] != 0 || visited[nextX][nextY]) continue;

                queue.offer(new int[]{nextX, nextY, day+1});
                visited[nextX][nextY] = true;
                box[nextX][nextY] = 1;
            }
            if(!queue.isEmpty() && queue.stream().allMatch(arr -> arr[2] == day+1)) result++;
        }
        return result;
    }
}
