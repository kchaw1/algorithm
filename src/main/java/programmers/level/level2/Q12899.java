package programmers.level.level2;

// 124 나라
public class Q12899 {
    public static void main(String[] args) {

        Q12899 q = new Q12899();

        for (int i = 0; i < 100; i++) {
            q.solution(i);
        }
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        String[] arr = {"4", "1", "2"};

        int number = n;

        while (number > 0) {
            int mod = number % 3;
            number /= 3;

            if(mod==0) number--;

            answer.insert(0, arr[mod]);
        }

        System.out.println(answer.toString());

        return answer.toString();
    }
}
