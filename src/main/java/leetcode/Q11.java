package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int l = height[left];
            int r = height[right];

            int h = Math.min(l, r);
            int w = h * (right - left);

            if (w > max) {
                max = w;
            }

            if (l < r) {
                ++left;
            } else {
                --right;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        Q11 q11 = new Q11();
        int[] input = {1,8,6,2,5,4,8,3,7};
        int i = q11.maxArea(input);

        System.out.println(i);
    }
}
