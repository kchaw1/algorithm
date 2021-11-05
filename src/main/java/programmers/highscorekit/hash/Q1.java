package programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {

        Q1 q1 = new Q1();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(q1.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 동명이인 가능

        // 1. 참가자명단으로 이름 : 개수 키밸류로 갖는 맵 생성
        Map<String, Integer> map = new HashMap<>();

        // 2. 맵에 데이터 입력
        for (int i = 0; i < participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            } else {
                int cnt = map.get(participant[i]);
                map.put(participant[i], cnt + 1);
            }
        }

        // 3. 완주자 명단을 맵을 돌며 카운트 -1
        for (int i = 0; i < completion.length; i++) {
            int cnt = map.get(completion[i]);
            map.put(completion[i], cnt-1);
        }

        // 4. 한번 더돌며 0이 아닌 유저 찾기
        for (String s : map.keySet()) {
            if(map.get(s) != 0) {
                answer = s;
                break;
            }
        }

        return answer;
    }
}
/*  
    // 기존 제출했던코드 효율성 에러
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        for(int i=0; i<participant.length; i++) {
            for (int j=0; j<completion.length; j++) {
                if(participant[i].equals(completion[j])) {
                    participant[i] = "";
                    completion[j] = "";
                }
            }
        }

        for(int i=0; i<participant.length; i++) {
            if (!participant[i].equals("")) {
                return participant[i];
            }
        }

        return answer;
    }
*/
