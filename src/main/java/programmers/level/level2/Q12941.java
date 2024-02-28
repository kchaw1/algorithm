package programmers.level.level2;

import java.util.Arrays;

public class Q12941 {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        int solution = solution(A, B);

        System.out.println(solution);
    }

//    public static int solution(int[] A, int[] B) {
//        int answer = 0;
//        int processCnt = 0;
//
//        while (processCnt < A.length) {
//            int[] resultA = findMinMax(A);
//            int[] resultB = findMinMax(B);
//
//            int result1 = resultA[0] * resultB[1];
//            int result2 = resultA[1] * resultB[0];
//
//            if (result1 < result2) {
//                answer += result1;
//                A[resultA[2]] = -1;
//                B[resultB[3]] = -1;
//            } else {
//                answer += result2;
//                A[resultA[3]] = -1;
//                B[resultB[2]] = -1;
//            }
//
//            ++processCnt;
//        }
//
//        return answer;
//    }
//
//    private static int[] findMinMax(int[] arr) {
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        int minIdx = -1, maxIdx = -1;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == -1) continue;
//
//            if (arr[i] < min) {
//                min = arr[i];
//                minIdx = i;
//            }
//
//            if (arr[i] > max) {
//                max = arr[i];
//                maxIdx = i;
//            }
//        }
//        return new int[]{min, max, minIdx, maxIdx};
//    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // 초기화
        int minAIdx = 0, minBIdx =0;
        int maxAIdx = A.length-1, maxBIdx =B.length-1;

        int processCnt = 0;

        while (processCnt < A.length) {
            int result1 = A[minAIdx] * B[maxBIdx];
            int result2 = A[maxAIdx] * B[minBIdx];

            if (result1 < result2) {
                answer += result1;
                minAIdx++;
                maxBIdx--;
            } else {
                answer += result2;
                maxAIdx--;
                minBIdx++;
            }
            ++processCnt;
        }

        return answer;
    }
}
