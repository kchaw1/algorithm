package baekjoon.series.nm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15649 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i1 = sc.nextInt();
        int i2 = sc.nextInt();

        visit = new boolean[i1];
        arr = new int[i2];

        print(i1, i2, 0);

        System.out.println(sb);
    }

    public static void print(int i1, int i2, int depth) {
        if (i2 == depth) {
            Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 0; i < i1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                print(i1,i2,depth+1);
                visit[i] = false;
            }
        }
    }
}
