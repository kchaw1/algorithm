package programmers.level.level1;

public class Q161990 {
    public static void main(String[] args) {
//        String[] arr = {".#...", "..#..", "...#."};
//        String[] arr = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] arr = {"..", "#."};

        solution(arr);
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            char[] charArray = wallpaper[i].toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];

                if (c == '#') {
                    if (i < top) {
                        top = i;
                    }
                    if (j < left) {
                        left = j;
                    }
                    if (i >= bottom) {
                        bottom = i + 1;
                    }
                    if (j >= right) {
                        right = j + 1;
                    }
                }
            }
        }

        answer[0] = top;
        answer[1] = left;
        answer[2] = bottom;
        answer[3] = right;

        return answer;
    }
}
