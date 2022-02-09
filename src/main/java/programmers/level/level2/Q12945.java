package programmers.level.level2;

import java.util.Arrays;

public class Q12945 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(99999));
    }

    static class Solution {

        public int solution(int n) {
            int answer = 0;

            int a = 0;
            int b = 1;

            for (int i = 2; i <= n; i++) {
                answer = (a+b) % 1234567;
                a = b;
                b = answer;
            }
            return answer;
        }
    }
}
