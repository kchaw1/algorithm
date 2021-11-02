package programmers.weekly;

import java.util.*;
import java.util.stream.Collectors;

public class Weekly6 {
    public static void main(String[] args) {

        Weekly6 test = new Weekly6();

        int[] a = {142,92,86};
        String[] b = {"NLW","WNL","LWN"};

        System.out.println(Arrays.toString(test.solution(a, b)));
    }

    public class PlayerInfo {
        private final double winRate;
        private final int winToHeavierCnt;
        private final int weight;
        private final int playerNum;

        public PlayerInfo(double winRate, int winToHeavierCnt, int weight, int playerNum) {
            this.winRate = winRate;
            this.winToHeavierCnt = winToHeavierCnt;
            this.weight = weight;
            this.playerNum = playerNum;
        }

        public double getWinRate() {
            return winRate;
        }

        public int getWinToHeavierCnt() {
            return winToHeavierCnt;
        }

        public int getWeight() {
            return weight;
        }

        public int getPlayerNum() {
            return playerNum;
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[head2head.length];

        List<PlayerInfo> list = new ArrayList<>();

        for (int i = 0; i < head2head.length; i++) {
            double winRate = 0;
            int winToHeavierCnt = 0;
            int weight = weights[i];
            int playerNum = i+1;

            String[] stats = head2head[i].split("");

            double totalRounds = Arrays.stream(stats).filter(s-> s.equals("W") || s.equals("L")).count();
            double winCnt = Arrays.stream(stats).filter(s -> s.equals("W")).count();


            // 승률
            if(totalRounds == 0) {
                winRate = 0;
            } else {
                winRate = (winCnt / totalRounds) * 100;
            }

            // 자신보다 무거운 상대를 이긴 횟수
            for(int k=0; k<stats.length; k++) {
                if(stats[k].equals("W") && weight < weights[k]) {
                    winToHeavierCnt++;
                }
            }

            Map<String,Object> map = new HashMap<>();

            PlayerInfo p = new PlayerInfo(winRate,winToHeavierCnt,weight,playerNum);

            list.add(p);
        }

        Comparator<PlayerInfo> priority = new Comparator<PlayerInfo>() {
            @Override
            public int compare(PlayerInfo o1, PlayerInfo o2) {
                double winRate1 = o1.getWinRate();
                double winRate2 = o2.getWinRate();

                int winToHeavierCnt1 = o1.getWinToHeavierCnt();
                int winToHeavierCnt2 = o2.getWinToHeavierCnt();

                int weight1 = o1.getWeight();
                int weight2 = o2.getWeight();

                int playerNum1 = o1.getPlayerNum();
                int playerNum2 = o2.getPlayerNum();

                int result1 = Double.compare(winRate2, winRate1);
                int result2 = Integer.compare(winToHeavierCnt2, winToHeavierCnt1);
                int result3 = Integer.compare(weight2, weight1);
                int result4 = Integer.compare(playerNum1, playerNum2);

                return result1 != 0 ? result1 : result2 != 0 ? result2 : result3 != 0 ? result3 : result4;
            }
        };

        list = list.stream().sorted(priority).collect(Collectors.toList());

        System.out.println(list);

        for(int j=0; j<list.size(); j++) {
            answer[j] = list.get(j).getPlayerNum();
        }

        return answer;
    }

//    public static String solution(String[] participant, String[] completion) {
//
//        int[][] arr = {{1,2},{1,2}};
//
//        System.out.println(Arrays.toString(arr));
//
//        return answer;
//    }
}
