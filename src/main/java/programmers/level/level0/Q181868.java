package programmers.level.level0;

import java.util.Arrays;

public class Q181868 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(" i    love  you")));
    }

    public static String[] solution(String my_string) {
        String[] answer;

        answer = my_string.trim().split(" ");

        return Arrays.stream(answer).filter(s -> !s.equals("")).toArray(String[]::new);
    }
}
