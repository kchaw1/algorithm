package programmers.kakao;

public class Q81301 {
    public static void main(String[] args) {
        Q81301 q = new Q81301();

        System.out.println(q.solution("1"));
    }

    public int solution(String s) {
        int answer = 0;

        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for (int i = 0; i < eng.length; i++) {
            if(s.contains(eng[i])) {
                s = s.replaceAll(eng[i], String.valueOf(i));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
