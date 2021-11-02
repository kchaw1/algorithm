package programmers.weekly;

import java.util.ArrayList;
import java.util.List;

public class Weekly5 {

    public static void main(String[] args) {

        Weekly5 week5 = new Weekly5();

        System.out.println(week5.solution("AEIOU"));
    }

    public int solution(String word) {
        int answer = 0;

        List<String> dictionary = new ArrayList<>();

        String[] wordArr = word.split("");

        String str = "";

        for (int i = 0; i < wordArr.length; i++) {
            makeWord(wordArr[i]);
        }


        return answer;
    }

    // 재귀 함수
    public String makeWord(String word) {
        System.out.println(word);
        if(word.length() > 5) {
            return word;
        } else {
            return makeWord(word);
        }
    }
}
