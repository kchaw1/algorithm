package programmers.level.level1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q172928 {

    static int[][] map;
    static int X;
    static int Y;
    static int nowX;
    static int nowY;

    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        Q172928 q = new Q172928();
        System.out.println(Arrays.toString(q.solution(park, routes)));
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        X = park[0].length();
        Y = park.length;

        map = new int[Y][X];

        for (int i = 0; i < park.length; i++) {
            String[] split = park[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("O")) {
                    map[i][j] = 1;
                } else if (split[j].equals("S")) {
                    map[i][j] = 1;
                    nowX = j;
                    nowY = i;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] split = routes[i].split(" ");
            String d = split[0];
            int n = Integer.parseInt(split[1]);
            move(d, n);
        }

        answer[0] = nowY;
        answer[1] = nowX;

        return answer;
    }

    private void move(String d, int n) {
        int tmpX = nowX;
        int tmpY = nowY;

        for (int i = 0; i < n; i++) {
            if (d.equals("E")) {
                tmpX += 1;
                if (tmpX == X || map[tmpX][tmpY] == 0) {
                    return;
                }
            } else if (d.equals("W")) {
                tmpX -= 1;
                if (tmpX < 0 || map[tmpX][tmpY] == 0) {
                    return;
                }
            } else if (d.equals("S")) {
                tmpY += 1;
                if (tmpY == Y || map[tmpX][tmpY] == 0) {
                    return;
                }
            } else if (d.equals("N")) {
                tmpY -= 1;
                if (tmpY < 0 || map[tmpX][tmpY] == 0) {
                    return;
                }
            }
        }
        nowX = tmpX;
        nowY = tmpY;
    }
}
