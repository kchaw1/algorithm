package programmers.level.level2;

import java.util.*;

/**
 * 입출력 예
 * priorities	        location	return
 * [2, 1, 3, 2]	            2	        1
 * [1, 1, 9, 1, 1, 1]	    0	        5
 */
public class Q42587 {
    public static void main(String[] args) {

//        System.out.println(solution(new int[] {2,1,3,2}, 2));
        System.out.println(solution(new int[] {1,1,9,1,1,1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        String[] arr = new String[priorities.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = UUID.randomUUID().toString();
        }
        String target = arr[location];

        Queue<String[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            String[] doc = new String[2];
            doc[0] = arr[i];
            doc[1] = String.valueOf(priorities[i]);
            q.add(doc);
        }

        while (true) {
            String[] doc = q.peek();
            String id = doc[0];
            int priority = Integer.parseInt(doc[1]);

            if(q.stream().anyMatch(s -> Integer.parseInt(s[1]) > priority)) {
                String[] poll = q.poll();
                q.add(poll);
            } else {
                String[] poll = q.poll();
                answer++;

                if(poll[0].equals(target)) break;;
            }
        }

        return answer;
    }
}