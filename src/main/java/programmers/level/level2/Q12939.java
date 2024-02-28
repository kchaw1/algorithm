package programmers.level.level2;

import java.util.Arrays;

public class Q12939 {
    public static void main(String[] args) {
        String solution = solution("-1 -2 -3 -4");
        System.out.println(solution);
    }

    public static String solution(String s) {
        String answer = "";

        String[] split = s.split(" ");
        int[] arr = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        return arr[0] + " " + arr[arr.length -1];
    }
}
