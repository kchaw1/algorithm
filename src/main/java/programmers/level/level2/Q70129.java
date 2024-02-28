package programmers.level.level2;

import java.util.Arrays;

public class Q70129 {

    public static void main(String[] args) {
        int[] solution = solution("110010101001");

        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(String s) {
        int n = 0;
        int len = 0;
        while (!s.equals("1")) {
            int tmp = s.length();
            s = s.replaceAll("0", "");
            len += tmp - s.length();

            s = Integer.toBinaryString(s.length());

            n++;
        }

        return new int[] {n, len};
    }
}
