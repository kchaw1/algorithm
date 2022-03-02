package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[][] lines;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        lines = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            String s1 = br.readLine();
            st = new StringTokenizer(s1, " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            lines[num1][num2] = lines[num2][num1] = 1;
        }

        int result = 0;
        for (int i = 1; i < lines.length; i++) {
            if (!visited[i]) {
                result += dfs(i);
            }
        }

        System.out.println(result);
    }

    public static int dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < lines.length; i++) {
            if (lines[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
        return 1;
    }
}
