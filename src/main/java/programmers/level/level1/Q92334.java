package programmers.level.level1;

import java.util.*;

public class Q92334 {

    /*public static void main(String[] args) {

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
    }*/

    static Map<String, Integer> reported = new HashMap<>();
    static Map<String, Set<String>> reportHistory = new HashMap<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        Arrays.stream(id_list).forEach(id -> reportHistory.put(id, new HashSet<>()));
        Arrays.stream(id_list).forEach(id -> reported.put(id, 0));

        for (String r : report) {
            String[] split = r.split(" ");

            String reporter = split[0];
            String reportee = split[1];

            Set<String> reportList = reportHistory.get(reporter);
            reportList.add(reportee);
            reportHistory.put(reporter, reportList);
        }

        setReported();

        return getResult(id_list, k);
    }

    public static void setReported() {
        for (Set<String> value : reportHistory.values()) {
            value.forEach(s -> {
                int cnt = reported.get(s);
                reported.put(s, cnt + 1);
            });
        }
    }

    public static int[] getResult(String[] id_list, int k) {
        int[] result = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            Set<String> set = reportHistory.get(id_list[i]);
            for (String reportee : set) {
                int reportCnt = reported.get(reportee);
                if (reportCnt >= k) {
                    result[i]++;
                }
            }
        }
        return result;
    }
    /**
     * id_list	report	k	result
     * ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
     * ["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
     * @param args
     */
    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

//    public static int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = new int[id_list.length];
//        Map<String, Integer> reported = new HashMap<>();
//        List<String> report2 = Arrays.stream(report).distinct().toList();
//
//        report2.forEach(s -> {
//            String[] split = s.split(" ");
//            String reportee = split[1];
//
//            reported.put(reportee, reported.getOrDefault(reportee, 0) + 1);
//        });
//
//        for (int i = 0; i < id_list.length; i++) {
//            for (String s : report2) {
//                String[] split = s.split(" ");
//                String reporter = split[0];
//                String reportee = split[1];
//                if (reporter.equals(id_list[i]) && reported.get(reportee) > k) {
//                    answer[i]++;
//                }
//            }
//        }
//
//        return answer;
//    }
}
