package programmers.level.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q17677 {
    public static void main(String[] args) throws IOException {

        Q17677 q = new Q17677();

        System.out.println(q.solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String word1, String word2) {
        int answer = 0;

        List<String> wordList1 = makeWordList(word1);
        List<String> wordList2 = makeWordList(word2);

        if(wordList1.size() == 0 && wordList2.size() == 0) return 65536;

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (String s : wordList1) {
            if (wordList2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        union.addAll(wordList2);

        double jaccard = (double) intersection.size() / union.size();

        answer = (int)Math.floor(jaccard * 65536);

        return answer;
    }

    public List<String> makeWordList(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length()-1; i++) {
            String sub = word.substring(i, i+2).toUpperCase();
            if(isAlphabet(sub)) list.add(sub);
        }
        return list;
    }

    public boolean isAlphabet(String word) {
        return word.matches("^[a-zA-Z]*$");
    }
}
