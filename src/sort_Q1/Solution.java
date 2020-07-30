package sort_Q1;

import java.util.Arrays;

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	System.out.println(Arrays.toString(commands[i]));
        	
        	int[] tempArr = {};
        	tempArr = splitArr(array, commands[i][0], commands[i][1]);
        	tempArr = sort(tempArr);
        	
        	answer[i] = findNum(tempArr, commands[i][2]);
        }
        
        return answer;
    }
	
	public int[] splitArr(int[] arr, int start, int end) {
		
		int arrLength = end - start + 1;
		
		int[] resultArr = new int[arrLength];
		int idx = 0;
		for(int i=start-1; i<end; i++) {
			resultArr[idx] = arr[i];
			idx++;
		}
		return resultArr;
	}
	
	public int[] sort(int[] arr) {
		int temp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}
	
	public int findNum(int[] arr, int idx) {
		System.out.println(Arrays.toString(arr));
		return arr[idx-1];
	}
}
