package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q13 {
    public static void main(String[] args) {

    }

    private Stack<String> stack = new Stack<>();
    private static final Map<String, Integer> ROMAN_NUMBER = new HashMap<String, Integer>() {
        {
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }
    };

    public int romanToInt(String s) {
        int result = 0;

        String[] split = s.split("");

        for (String s1 : split) {
            stack.push(s1);
        }

        return result;
    }

    public int calculateNumber(String roman1, String roman2) {
        return 0;
    }
}
