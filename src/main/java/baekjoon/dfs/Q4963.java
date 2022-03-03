package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963 {

    static boolean[][] visited;
    static int[][] islands;
    static int W, H;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1}; // ← → ↑ ↓ ↖ ︎↗ ︎↙ ︎↘︎
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1}; // ← → ↑ ↓ ↖ ︎↗ ︎↙ ︎↘︎

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String wh = br.readLine();
            st = new StringTokenizer(wh, " ");

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break; // 종료조건

            islands = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                st = new StringTokenizer(s, " ");
                for (int j = 0; j < W; j++) {
                    islands[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (islands[i][j] != 0 && !visited[i][j]) result += dfs(j, i);
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int dfs(int x, int y) {
        visited[y][x] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= W || nextY >= H // 배열범위
                    || islands[nextY][nextX] == 0 || visited[nextY][nextX]) continue; // 바다여부, 방문여부
            dfs(nextX, nextY);
        }
        return 1;
    }

}
