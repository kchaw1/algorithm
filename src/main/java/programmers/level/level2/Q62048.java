package programmers.level.level2;

public class Q62048 {
    public static void main(String[] args) {
        Q62048 q = new Q62048();

        System.out.println(q.solution(12, 8));
    }

    public long solution(int w, int h) {
        long answer = 0;

        for (long i = 1; i < w; i++) {
            answer += h*i/w;
        }

        return answer * 2;
    }
}
