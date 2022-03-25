package programmers.level.level2;

public class Q43165 {

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers,0, 0, target);
        return answer;
    }

    public static void dfs(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length) {
            if(sum == target) answer++;
        } else {
            dfs(numbers, sum + numbers[index], index+1, target);
            dfs(numbers, sum - numbers[index], index+1, target);
        }
    }
}
