package programmers.level.level0;

public class Q181874 {

    public static void main(String[] args) {
        System.out.println(solution("abstract algebra"));
    }

    public static String solution(String myString) {
        myString = myString.toLowerCase();
        myString = myString.replace("a", "A");

        return myString;
    }

}
