package programmers.highscorekit.satckqueue;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();

        int[] progress= {98, 98 , 98};
        int[] speeds= {1,1,1,1,1,1};

        System.out.println(Arrays.toString(q1.solution(progress, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainDay = (int) Math.ceil((float)(100 - progresses[i]) / speeds[i]);

            queue.add(remainDay);
        }

        int prev = -1; // 초기값
        int deployCnt = 1;
        while (true) {
            if (queue.peek() == null) {
                result.add(deployCnt);
                break;
            }

            int now = queue.remove();
            if (prev == -1) {
                prev = now;
                continue;
            }

            if (now > prev) {
                result.add(deployCnt);
                deployCnt = 1;
                prev = now;
            } else {
                deployCnt++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
