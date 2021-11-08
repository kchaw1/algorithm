package programmers.highscorekit.hash;

import java.util.*;

public class Q4 <T> {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "hiphop", "hiphop", "hiphop", "ballad"};
        int[] plays = {500, 600, 500, 800, 2500, 5000, 3000, 100, 1500};

        Q4 q4 = new Q4();

        System.out.println(Arrays.toString(q4.solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> sumMap = new HashMap<>();

        List<Music> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0)+ plays[i]);

            Music music = new Music(genres[i], plays[i], i);

            list.add(music);
        }

        List<String> rank = new ArrayList<>();

        while (!sumMap.isEmpty()) {
            String maxKey = "";
            for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
                if(maxKey.equals("")) {
                    maxKey = entry.getKey();
                    continue;
                }
                if (sumMap.get(maxKey) < entry.getValue()) {
                    maxKey = entry.getKey();
                }
            }
            rank.add(maxKey);
            sumMap.remove(maxKey);
        }

        for (int i = 0; i < rank.size(); i++) {
            for (Music music : list) {
                if (rank.get(i).equals(music.genre)) {
                    music.rank = i;
                }
            }
        }

        list.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                // 랭킹순
                if(o1.rank > o2.rank) {
                    return 1;
                } else if(o1.rank < o2.rank) {
                    return -1;
                } else if (o1.play < o2.play) {
                    return 1;
                } else if(o1.play > o2.play) {
                    return -1;
                } else if(o1.idx < o2.play) {
                    return 1;
                } else if(o1.idx > o2.play) {
                    return -1;
                }
                return 0;
            }
        });

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> keyMap = new HashMap<>();
        for (Music music : list) {
            String key = music.genre;
            keyMap.put(key , keyMap.getOrDefault(key,0)+1);

            if (keyMap.get(key) > 2) {
                continue;
            }

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(key) && plays[i] == music.play && music.idx == i) {
                    result.add(i);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public class Music {
        String genre;
        int play;
        int idx;
        int rank;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", play=" + play +
                    ", idx=" + idx +
                    ", rank=" + rank +
                    '}';
        }
    }
}
