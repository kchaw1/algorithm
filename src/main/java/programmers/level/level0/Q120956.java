package programmers.level.level0;

public class Q120956 {

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        String[] babbling2 = {"aya", "yee", "u", "maa", "wyeoo"};

        Q120956 q = new Q120956();
        System.out.println(q.solution(babbling));
        System.out.println(q.solution(babbling2));
    }

    public int solution(String[] babbling) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String s1 : babbling) {
            for (String s2 : possible) {
                s1 = s1.replace(s2, " ");
            }
            if (s1.matches("^\\s*$")) answer++;
        }
        return answer;
    }
}
