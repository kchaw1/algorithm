package programmers.level.level1;

public class Q86051 {
    public static void main(String[] args) {
        int[] arr = {5,8,4,0,6,7,9};
        System.out.println(solution(arr));
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        int[] arr = new int[10];

        for (int number : numbers) {
            arr[number] = number;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) answer+=i;
        }

        return answer;
    }
}
