package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {

    static int N;
    static boolean[][] visited;
    static String[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isColorBlindness;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        grid = new String[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            if (N >= 0) System.arraycopy(split, 0, grid[i], 0, N);
        }

        int result = 0;

        // 1 색맹 X 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) result += dfs(i, j);
            }
        }

        sb.append(result).append(" "); // 6 결과값 저장

        // 7 초기화, 플래그 변경
        result = 0;
        visited = new boolean[N][N];
        isColorBlindness = true;

        // 8 색맹 O 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) result += dfs(i, j);
            }
        }

        // 9 누적 후 결과 출력
        sb.append(result);
        System.out.println(sb);
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true; // 2 방문여부 업데이트

        String color = grid[x][y];

        for (int i = 0; i < dx.length; i++) { // 3 현재좌표를 기준으로 좌우하상 순으로 좌표 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextX][nextY]) continue; // 4 범위와 방문여부 유효성 체크
            String nextColor = grid[nextX][nextY];
            // 5 색맹여부에 따른 다음탐색 결정을 위한 조건문
            if (!isColorBlindness) {
                if(color.equals(nextColor)) dfs(nextX, nextY);
            } else {
                if (color.equals("B")) {
                    if(color.equals(nextColor)) dfs(nextX, nextY);
                } else {
                    if(!nextColor.equals("B")) dfs(nextX, nextY);
                }
            }
        }

        return 1;
    }
}
