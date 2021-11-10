package programmers.highscorekit.hash;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {

        Q3 q3 = new Q3();

        String[][] clothes = {{"circleglasses", "face"}, {"blacksunglasses", "face"}, {"bluetshirts", "top"}, {"bluejeans", "bottom"}, {"longcoat", "outer"}};

        System.out.println(q3.solution(clothes));

    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }

        System.out.println(map);

        for (String key : map.keySet()) {
            answer *= map.get(key)+1;
        }

        return answer-1;
    }


}
