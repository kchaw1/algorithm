package baekjoon.stepbystep.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {

    static int[][] connects;
    static int n,m;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        connects = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            connects[num1][num2] = connects[num2][num1] =1;
        }

        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <=n; i++) {
            if (connects[start][i] == 1 && !visited[i]) {
                ++result;
                dfs(i);
            }
        }
    }
}
