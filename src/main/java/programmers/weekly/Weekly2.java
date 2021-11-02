package programmers.weekly;

import java.util.Arrays;

public class Weekly2 {

    public static void main(String[] args) {

        Weekly2 week2 = new Weekly2();

        //int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        int[][] scores = {{70,49,90},{68,50,38},{73,31,100}};

        System.out.println(week2.solution(scores));
    }

    public String solution(int[][] scores) {
        String answer = "";

        for(int i=0; i<scores.length; i++) {
            double avg = 0;
            double sum = 0;

            int[] recvScore = new int[scores.length];
            for (int k = 0; k < scores.length; k++) {
                recvScore[k] = scores[k][i];
            }

            int selfScore = recvScore[i];

            int maxScore = Arrays.stream(recvScore).max().getAsInt();
            int minScore = Arrays.stream(recvScore).min().getAsInt();

            boolean isMax = selfScore == maxScore;
            boolean isMin = selfScore == minScore;

            sum = Arrays.stream(recvScore).sum();

            if((isMax && isOnly(recvScore, maxScore)) || (isMin && isOnly(recvScore, minScore))) {
                avg = (sum - recvScore[i]) / (recvScore.length -1);
            } else {
                avg = sum / recvScore.length;
            }

            System.out.println(avg);

            answer += getGrade(avg);
        }

        return answer;
    }

    public String getGrade(double score) {
        if(score >= 90) {
            return "A";
        } else if(score >= 80) {
            return "B";
        } else if(score >= 70) {
            return "C";
        } else if(score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public boolean isOnly(int[] arr , int findNum) {
        return Arrays.stream(arr).filter(num -> num == findNum).count() == 1;
    }
}
