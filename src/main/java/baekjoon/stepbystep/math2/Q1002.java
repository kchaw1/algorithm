package baekjoon.stepbystep.math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d; // 두중심 사이의 거리

            if(x1 == x2 && y1 == y2){ //동심원인경우
                d = 0;
            } else if(x1 == x2) { //수직선인 경우 1
                d = Math.abs(y1 - y2);
            } else if(y1 == y2) { //수평선인 경우 2
                d = Math.abs(x1 - x2);
            } else { // 그외
                d = Math.sqrt((Math.pow(Math.abs(x1-x2),2) + (Math.pow(Math.abs(y1-y2),2))));
            }

            // 동심원인경우
            if(d==0) {
                if(r1 == r2) { // 반지름이 같은경우 -> 무한대
                    sb.append(-1);
                } else {
                    sb.append(0);
                }
            } else if(r1 > r2) { // r1가 더 큰원일 경우
                sb.append(getContactCnt(r2, r1, d));
            } else { // r2이 더 큰원일 경우 또는 같은경우
                sb.append(getContactCnt(r1, r2, d));
            }

            if (i != size - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static int getContactCnt(int r1, int r2, double d) {
        if(r2 - r1 < d && d < r1+r2) { // 두점에서 만나는 경우
            return 2;
        } else if(r2-r1 == d || r1+r2 == d) { // 한점에서 만나는 경우
            return 1;
        } else {
            return 0;
        }
    }
}
/**
 * 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
 * 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 *
 * 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
 * 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
 * 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 3
 * 0 0 13 40 0 37
 * 0 0 3 0 7 4
 * 1 1 1 1 1 5
 *
 * 출력
 * 2
 * 1
 * 0
 */