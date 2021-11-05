package programmers.highscorekit.hash;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        String[] phone_book = {"12","123","1235","567","88"};

        System.out.println(q2.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String out : set) {
            for (int i = 0; i < out.length(); i++) {
                String sub = out.substring(0, i);

                if(set.contains(sub)) return false;
            }
        }

        return answer;
    }
}

