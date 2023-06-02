package programmers.level.level0;

import java.util.Arrays;

public class Q181883 {

    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4};
        int[][] queries = {{0,1},{1,2},{2,3}};
        System.out.println(Arrays.toString(solution(arr, queries)));
    }

    public static int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < queries.length; j++) {
                int[] query = queries[j];
                if (query[0] <= i && i <= query[1]) {
                    arr[i] += 1;
                }
            }
        }
        return arr;
    }
}
