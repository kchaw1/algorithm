package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q7562 {

    static int size;
    static boolean[][] visit;
    static int[][] map;
    static int[] dx = {2,2,-2,-2,-1,1,-1,1};
    static int[] dy = {-1,1,-1,1,2,2,-2,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            size = Integer.parseInt(br.readLine());
            visit = new boolean[size][size];
            map = new int[size][size];

            String[] arr = br.readLine().split(" ");
            int startX = Integer.parseInt(arr[0]);
            int startY = Integer.parseInt(arr[1]);

            arr = br.readLine().split(" ");
            int targetX = Integer.parseInt(arr[0]);
            int targetY = Integer.parseInt(arr[1]);

            if (startX == targetX && startY == targetY) {
                System.out.println(0);
            } else {
                bfs(startX, startY, targetX, targetY);
                System.out.println(map[targetX][targetY]);
            }
        }
    }

    public static void bfs(int x, int y, int targetX, int targetY) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX < 0 || nextY < 0 || size <= nextX || size <= nextY) { continue; }
                if (visit[nextX][nextY]) continue;

                q.offer(new int[]{nextX, nextY});
                visit[nextX][nextY] = true;
                map[nextX][nextY] = map[now[0]][now[1]] + 1;

                if (nextX == targetX && nextY == targetY) {
                    return;
                }
            }
        }
    }

}
