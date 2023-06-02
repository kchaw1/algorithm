package programmers.level.level0;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Q181916 {

    public static void main(String[] args) {
        System.out.println(solution(2,5,2,6));
    }

    public static int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {a, b, c, d};

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Entry<Integer, Integer>> entry = map.entrySet();

        if (entry.size() == 1) { // all
            return 1111 * a;
        } else if (entry.size() == 2 && entry.stream().anyMatch(e -> e.getValue() == 2)) { // twin_two
            int sum = entry.stream().mapToInt(Entry::getKey).sum();
            int sub = entry.stream().mapToInt(Entry::getKey).reduce((x, y) -> x - y).getAsInt();
            return sum * Math.abs(sub);
        } else if (entry.size() == 3) { // twin_one
            return entry.stream()
                .filter(e -> e.getValue() != 2)
                .mapToInt(Entry::getKey)
                .reduce((x, y) -> x * y)
                .getAsInt();
        } else if (entry.size() == 4) { // none
            return entry.stream().map(Entry::getKey).min(Integer::compareTo).get();
        } else { // TRIPLE
            // (10 × p + q)^2
            int sum = entry.stream().mapToInt(e -> {
                if (e.getValue() == 3) {
                    return 10 * e.getKey();
                }
                return e.getKey();
            }).sum();
            return sum * sum;
        }
    }
}
