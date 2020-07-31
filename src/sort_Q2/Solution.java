package sort_Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 정렬 > 가장 큰수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * 
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
		
입출력 예
numbers				return
[6, 10, 2]			6210
[3, 30, 34, 5, 9]	9534330
*/

public class Solution {
	public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = splitArr(numbers);
        
        answer = sort(arr);
        
        return answer;
    }
	
	public String[] splitArr(int[] numbers) {
		List<String> splitedList = new ArrayList<>();
		for(int i=0; i<numbers.length; i++) {
        	String num = String.valueOf(numbers[i]);

    		for(String temp : num.split("")) {
    			splitedList.add(temp);
    		}
        }
		return splitedList.toArray(new String[splitedList.size()]);
	}
	
	public String sort(String[] arr) {
		String maxNum = "";
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length-1; i++) {
			int tempNum = 0;
			for(int j=i+1; j<arr.length; j++) {
				int currVal = Integer.parseInt(arr[i]);
				int nextVal = Integer.parseInt(arr[j]);
				
				if(nextVal > currVal) {
					tempNum = nextVal;
					arr[i] = String.valueOf(tempNum);
					arr[j] = String.valueOf(currVal);
				}
			}
			maxNum += String.valueOf(arr[i]);
			if(i==arr.length-2) maxNum +=(arr[arr.length-1]);
		}
		
		return maxNum;
	}
}
