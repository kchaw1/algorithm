package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    public static int[][] lines;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        lines = new int[N+1][N+1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            lines[n1][n2] = lines[n2][n1] = 1;
        }

        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < lines.length; i++) {
            if (lines[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int head = q.poll();

            for (int i = 1; i < lines.length; i++) {
                if (lines[head][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }

}
