package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Q17 {

    static Map<Integer, String> keyPad;
    static List<String> output;
    static {
        keyPad = Map.of(
                2, "abc",
                3, "def",
                4, "ghi",
                5, "jkl",
                6, "mno",
                7, "pqrs",
                8, "tuv",
                9, "wxyz"
        );
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }

        output = new ArrayList<>();

        backTracking(digits, 0, "");

        return output;
    }

    private void backTracking (String digits, int index, String letter) {
        if (index >= digits.length()) {
            output.add(letter);
            return;
        }

        String num = digits.substring(index, index + 1);
        String s = keyPad.get(Integer.parseInt(num));
        ++index;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            backTracking(digits, index, letter + sub);
        }
    }
}
