package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q1844 {
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int M;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}; // 11
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}; // -1

        N = maps[0].length;
        M = maps.length;

        visit = new boolean[M][N];

        System.out.println(bfs(0,0,maps2));
    }

    static int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();

        visit[x][y] = true;
        q.offer(new Node(x, y, maps[x][y]));

        while (!q.isEmpty()) {
            Node poll = q.poll();

            int nowX = poll.x;
            int nowY = poll.y;
            int nowDist = poll.dist;

            if(nowX == N-1 && nowY == M-1) return nowDist;

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX == N || nextY == M
                || maps[nextY][nextX] == 0 || visit[nextY][nextX]) continue;

                q.offer(new Node(nextX, nextY, nowDist + 1));
                visit[nextY][nextX] = true;
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
