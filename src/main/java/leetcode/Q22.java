package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, "", result);
        return result;
    }

    private void generateParenthesisHelper(int left, int right, String current, List<String> result) {
        // 유효한 괄호 조합인 경우 결과에 추가
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        // 왼쪽 괄호를 추가할 수 있는 경우
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, current + "(", result);
        }

        // 오른쪽 괄호를 추가할 수 있는 경우 (단, 오른쪽 괄호는 왼쪽 괄호보다 많은 경우에만 추가 가능)
        if (right > left) {
            generateParenthesisHelper(left, right - 1, current + ")", result);
        }
    }
}
