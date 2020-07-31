package test;

class Solution {
public int[] solution(int[] array, int[][] commands) {
	int[] answer = {};
	int[] temp = {};
	int min = 101;
	int i,j,k,n= 0;
	int tem,index = 0;

    for(int t=0;t<commands[t].length;t++){

        i = commands[t][0] - 1;
        j = commands[t][1];
        k = commands[t][2] - 1;

        answer = new int[commands[t].length];
        temp = new int[j-i];

        for(int m = i;m < j;m++){
            if(i+1 == j){
                answer[t] = array[i];
                continue;
            }
            temp[n] = array[m]; //i번째부터 j번째까지 잘라서 temp에 넣어줌
            n++;
        }

        for(int a = 0;a<temp.length;a++){ //temp배열을 탐색정렬을 이용해 정렬
            for(int b = a;b<temp.length;b++){
                if(min > temp[b]){
                    min = temp[b];
                    index = b;
                }
            }
            tem = temp[a];
            temp[a] = temp[index];
            temp[index] = tem;
        }
        answer[t] = temp[k]; //정렬한 배열의 k번째 수를 넣어줌
    }

    return answer;
}
}
