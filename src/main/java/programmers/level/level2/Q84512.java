package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

public class Q84512 {
    static List<String> list = new ArrayList<>();
    static String[] arr = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        System.out.println(solution("UUUUU"));
        System.out.println(list);
    }

    public static int solution(String word) {
        int answer = 0;
        createDictionary("",0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) return i+1;
        }
        return answer;
    }

    public static void createDictionary(String str, int len) {
        if(!str.equals("")) list.add(str);
        for (String s : arr) {
            if (len < 5) createDictionary(str + s, len + 1);
        }
    }
}
