package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Q4 {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3,4};

        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double result = 0;
//        List<Integer> list = new ArrayList<>();
//
//        for (int i : nums1) {
//            list.add(i);
//        }
//        for (int i : nums2) {
//            list.add(i);
//        }
//
//        list = list.stream().sorted().collect(Collectors.toList());
//
//        if (list.size() % 2 == 0) {
//            result = (list.get(list.size() / 2) + list.get((list.size() / 2) -1)) / 2.0;
//        } else {
//            result = list.get(list.size() / 2);
//        }
//
//        return result;

        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2] ) {
                med2 = nums1[index1];
                index1++;
            }  else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length+nums2.length)%2 == 0) {
            return (float)(med1+med2)/2;
        }

        return med2;
    }
}
