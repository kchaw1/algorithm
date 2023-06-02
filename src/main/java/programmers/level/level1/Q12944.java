package programmers.level.level1;

public class Q12944 {

    public static void main(String[] args) {

    }

    public double solution(int[] arr) {
        double a = 0;
        for(int i=0; i<arr.length; i++) {
            a += arr[i];
        }

        return a / arr.length;
    }
}
