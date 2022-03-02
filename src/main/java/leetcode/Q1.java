package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    /*public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        outer:for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(i==j) continue;
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break outer;
                }
            }
        }
        return answer;
    }*/

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int a = target - nums[i];
            if(map.containsKey(a)) return new int[] {map.get(a), i};
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
