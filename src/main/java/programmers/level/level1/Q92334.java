package programmers.level.level1;

import java.util.*;

public class Q92334 {

    public static void main(String[] args) {

        Solution sol = new Solution();

//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        System.out.println(Arrays.toString(sol.solution(id_list, report, k)));

    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            Map<String, Set<String>> reportResult = new HashMap<>();

            for (int i = 0; i < report.length; i++) {
                String[] s = report[i].split(" ");

                String reporter = s[0];
                String reported = s[1];

                if(!reportResult.containsKey(reported)) {
                    Set<String> reporters = new HashSet<>();
                    reporters.add(reporter);
                    reportResult.put(reported, reporters);
                } else {
                    reportResult.get(reported).add(reporter);
                }
            }

            for (Set<String> reporters : reportResult.values()) {
                if(reporters.size() >= k) {
                    for (String s : reporters) {
                        for (int i = 0; i < id_list.length; i++) {
                            if (id_list[i].equals(s)) {
                                answer[i]++;
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }
}
