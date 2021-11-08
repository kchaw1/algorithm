package programmers.highscorekit.satckqueue;

import java.util.*;

public class Q1_solving {

    public static void main(String[] args) {
        Q1_solving q1 = new Q1_solving();

        int[] progress= {93, 30, 55};
        int[] speeds= {1, 30, 5};

        q1.solution(progress, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainDay = (int) Math.ceil((float)(100 - progresses[i]) / speeds[i]);

            queue.add(remainDay);
        }

        List<Integer> result = new ArrayList<>();

        System.out.println(queue);

        int prev = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() <= prev) {
                count++;
                prev = queue.remove();
            } else {
                result.add(count);
                count = 1;
                prev = queue.remove();
            }
        }


        System.out.println(result);

        return answer;
    }
}
