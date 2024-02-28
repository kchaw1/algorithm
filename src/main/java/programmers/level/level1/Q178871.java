package programmers.level.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q178871 {

    static Map<String, Integer> indexer = new HashMap<>();

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution(players, callings);

        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] players, String[] callings) {
        for (int i = 0; i < players.length; i++) {
            indexer.put(players[i], i);
        }

        for (String calling : callings) {
            switchPlayer(players, calling);
        }
        return players;
    }

    public static void switchPlayer(String[] players, String called) {
        int i = indexer.get(called);

        String tmp = players[i - 1];
        players[i - 1] = players[i];
        players[i] = tmp;

        indexer.put(called, i - 1);
        indexer.put(tmp, i);
    }
}
