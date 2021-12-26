package programmers.level.level2;

import java.util.*;

class Q1829 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Q1829 q1829 = new Q1829();

        int m = 13;
        int n = 16;
        int[][] picture = {
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}
                ,{0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}
                ,{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
                ,{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
                ,{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}
                ,{0,1,1,1,1,3,1,1,1,1,3,1,1,1,1,0}
                ,{0,1,1,1,3,1,3,1,1,3,1,3,1,1,1,0}
                ,{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}
                ,{0,1,2,2,2,1,1,1,1,1,1,2,2,2,1,0}
                ,{0,1,1,1,1,1,3,1,1,3,1,1,1,1,1,0}
                ,{0,0,1,1,1,1,1,3,3,1,1,1,1,1,0,0}
                ,{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
                ,{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
        };


        System.out.println(Arrays.toString(q1829.solution(m,n,picture)));

    }

    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j]==0 || visit[i][j]) continue;
                results.add(bfs(i,j,m,n,picture[i][j], picture));
            }
        }

        System.out.println(results);

        Collections.sort(results);

        int numberOfArea = results.size();
        int maxSizeOfOneArea = results.get(results.size()-1);

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int x, int y,int m, int n, int level, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {x,y});
        visit[x][y] = true;

        int result = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
                if(visit[nextX][nextY]
                        || picture[nextX][nextY] != level) continue;

                q.offer(new int[] {nextX, nextY});
                visit[nextX][nextY] = true;
                result++;
            }
        }
        return result;
    }
}