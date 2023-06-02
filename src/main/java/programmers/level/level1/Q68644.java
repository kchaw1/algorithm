package programmers.level.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q68644 {

    public static void main(String[] args) {
    }

    public int[] solution(int[] numbers) {
        int[] answer;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if(i==j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[set.size()];

        int i =0;
        for (Integer integer : set) {
            answer[i] = integer;
            i++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
