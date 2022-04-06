package leetcode;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;

        int start = 0;
        int end = 0;

        String temp = "";
        while (end < s.length()) {
            if (temp.contains(Character.toString(s.charAt(end)))) {
                start = start + 1;
                end = start;
            }
            end = end+1;
            temp = s.substring(start, end);

            if(temp.length() > result) result = temp.length();
        }
        return result;
    }
}
