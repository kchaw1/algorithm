package programmers.kakao;

import java.util.*;

public class Q42888 {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

        Q42888 q = new Q42888();

        System.out.println(
                Arrays.toString(q.solution(record))
        );
    }

    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String command = record[i].split(" ")[0];

            if(command.equals("Leave")) continue;

            String id = record[i].split(" ")[1];
            String name = record[i].split(" ")[2];

            if (command.equals("Enter") || command.equals("Change")) {
                map.put(id, name);
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String command = record[i].split(" ")[0];

            if(command.equals("Change")) continue;

            String name = map.get(record[i].split(" ")[1]);

            String message = "";

            if (command.equals("Enter")) {
                message += name + "님이 들어왔습니다.";
                result.add(message);
            }else if (command.equals("Leave")) {
                message += name + "님이 나갔습니다.";
                result.add(message);
            }
        }

        answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
