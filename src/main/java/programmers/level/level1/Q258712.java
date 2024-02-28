package programmers.level.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q258712 {

    static Map<String, Integer> score = new HashMap<>();
    static Map<String, Map<String, Integer>> giveHistory = new HashMap<>();
    static Map<String, Integer> nextMonthGifts = new HashMap<>();

    public static void main(String[] args) {
//        String[] friends = {"muzi", "ryan", "frodo", "neo"};
//        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};

        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        Arrays.stream(friends).forEach(s -> score.put(s, 0));
        Arrays.stream(friends).forEach(s -> giveHistory.put(s, new HashMap<>()));
        Arrays.stream(friends).forEach(s -> nextMonthGifts.put(s, 0));

        createMap(gifts);

        for (String me : friends) {
            for (String friend : friends) {
                if (me.equals(friend)) {
                    continue;
                }
                int meToFriend = getHistAtoB(me, friend);
                int friendToMe = getHistAtoB(friend, me);

                int next = nextMonthGifts.getOrDefault(me, 0);
                if (meToFriend > friendToMe) {
                    nextMonthGifts.put(me, ++next);
                } else if (meToFriend == friendToMe) {
                    int meScore = score.get(me);
                    int friendScore = score.get(friend);

                    if (meScore > friendScore) {
                        nextMonthGifts.put(me, ++next);
                    }
                }
            }

        }
        return nextMonthGifts.values().stream().max(Integer::compareTo).get();
    }

    public static void createMap(String[] gifts) {
        for (String gift : gifts) {
            String[] split = gift.split(" ");

            String giver = split[0];
            String receiver = split[1];

            score.put(giver, score.get(giver) + 1);
            score.put(receiver, score.get(receiver) - 1);

            Map<String, Integer> hist = giveHistory.get(giver);
            hist.put(receiver, hist.getOrDefault(receiver, 0) + 1);
        }
    }

    public static int getHistAtoB(String a, String b) {
        return giveHistory.get(a).getOrDefault(b, 0);
    }
}
