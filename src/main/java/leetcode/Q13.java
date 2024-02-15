package leetcode;

import java.util.Map;

public class Q13 {
    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     */

    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of(
          "I", 1,
          "V", 5,
          "X", 10,
          "L", 50,
          "C", 100,
          "D", 500,
          "M", 1000
        );

        int result = 0;
        int lastNum = 0;
        for (int i=s.length(); i > 0; i--) {
            String sub = s.substring(i-1, i);

            int num = map.get(sub);
            boolean condition1 = (lastNum == 5 || lastNum == 10) && num == 1;
            boolean condition2 = (lastNum == 50 || lastNum == 100) && num == 10;
            boolean condition3 = (lastNum == 500 || lastNum == 1000) && num == 100;
            if (condition1 || condition2 || condition3) {
                result -= num;
            } else {
                result += num;
            }
            lastNum = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Q13 rti = new Q13();

        System.out.println(rti.romanToInt("IV"));
    }
}
