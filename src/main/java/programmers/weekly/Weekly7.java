package programmers.weekly;

import java.util.*;

public class Weekly7 {

    public static void main(String[] args) {

        Weekly7 week = new Weekly7();

        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};

        // answer =  [2,2,1,3]

        System.out.println(Arrays.toString(week.solution(enter, leave)));
    }

    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        List<Integer> room = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < enter.length || idx2 < leave.length){
            if(room.contains(leave[idx2])) {
                int finalIdx = idx2;
                room.removeIf(num -> num == leave[finalIdx]);
                answer[leave[idx2]-1] += room.size();
                room.forEach(num -> answer[num-1]++);
                idx2++;
            } else {
                room.add(enter[idx1]);
                idx1++;
            }
        }

        return answer;
    }
}
