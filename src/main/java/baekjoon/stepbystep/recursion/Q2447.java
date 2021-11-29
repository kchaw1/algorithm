package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://iseunghan.tistory.com/202 참고함.. 재귀는 어렵다
public class Q2447 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        arr = new char[size][size];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, size);

        for (char[] chars : arr) {
            for (char c : chars) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void star(int x, int y, int size) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(x+i*(size/3), y+j*(size/3), size/3);
                }
            }
        }
    }
}