package programmers.highscorekit.satckqueue;

import java.util.*;

public class Q2 {
    /**
     * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
     * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
     * 3. 그렇지 않으면 J를 인쇄합니다.
     */
    public static void main(String[] args) {
        Q2 q2 = new Q2();

        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(q2.solution(priorities,location));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Document document = new Document(priorities[i], i);
            queue.add(document);
        }

        while (!queue.isEmpty()) {
            Document head = queue.poll();
            boolean flag = false;
            for (Document doc : queue) {
                if (head.priority < doc.priority) {
                    flag = true;
                }
            }
            if (flag) {
                queue.add(head);
            } else {
                answer++;
                if (head.idx == location) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static class Document{
        final int priority;
        final int idx;

        public Document(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "priority=" + priority +
                    ", idx=" + idx +
                    '}';
        }
    }
}
