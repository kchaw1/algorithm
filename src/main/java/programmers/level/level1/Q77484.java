package programmers.level.level1;

import java.util.Arrays;

public class Q77484 {

    public static void main(String[] args) {
        Q77484 q = new Q77484();

        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(q.solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int matches = 0;
        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]){
                    matches++;
                }
            }
        }

        int zeroes = (int)Arrays.stream(lottos).filter(i -> i == 0).count();

        if (matches == 6) {
            answer[0] = 1;
            answer[1] = 1;
        } else if (matches == 5) {
            answer[1] = 2;
        } else if (matches == 4) {
            answer[1] = 3;
        } else if (matches == 3) {
            answer[1] = 4;
        } else if (matches == 2) {
            answer[1] = 5;
        } else {
            answer[1] = 6;
        }

        answer[0] = answer[1] - zeroes;
        if(answer[0] < 1 ) answer[0] = 1;
        return answer;
    }
}
