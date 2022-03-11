package programmers.level.level2;

import java.util.*;
import java.util.stream.Collectors;

public class Q42746 {
    public static void main(String[] args) {

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (1000 + 1));
        }


//        System.out.println(solution(arr));
        System.out.println(solution(new int[] {0, 0, 1}));
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.stream(arr).sorted((o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        }).forEach(sb::append);

        if(sb.toString().startsWith("0")) return "0";

        return sb.toString();
    }

    /*public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> sList = new ArrayList<>();

        for (int number : numbers) {
            sList.add(String.valueOf(number));
        }

        sList.stream().sorted((o1, o2) -> {
            System.out.println(o1 + " , " + o2);

            int head1 = Integer.parseInt(o1.substring(0, 1));
            int head2 = Integer.parseInt(o2.substring(0, 1));

            int result = 0;

            if (head1 > head2) {
                result = -1;
            } else if (head1 < head2) {
                result = 1;
            } else { // 같을경우
                if (o1.length() == o2.length()) { // 길이가 같다면 큰수
                    if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                        result = -1;
                    } else if(Integer.parseInt(o1) < Integer.parseInt(o2)) {
                        result = 1;
                    }
                } else { // 길이가 다르다면 -> 아래자리수 탐색해서 리턴
                    result = findNum(o1, o2, 0);
                }
            }
            return result;
        }).collect(Collectors.toList()).forEach(answer::append);



        return answer.toString();
    }

    public static int findNum(String s1, String s2, int idx) {
        int i1,i2;
        if (s1.length() == idx && s2.length() > idx) {
            i1 = subStrAndParseInt(s1, 0, 1);
            i2 = subStrAndParseInt(s2, idx, idx + 1);
            if(i1 == i2) return 0;
        } else if (s1.length() > idx && s2.length() == idx) {
            i1 = subStrAndParseInt(s1, idx, idx + 1);
            i2 = subStrAndParseInt(s2, 0, 1);
            if(i1 == i2) return 0;
        }  else {
            i1 = subStrAndParseInt(s1, idx, idx + 1);
            i2 = subStrAndParseInt(s2, idx, idx + 1);
        }
        if(i1 > i2) {
            return -1;
        } else if (i1 < i2) {
            return 1;
        }
        return findNum(s1, s2, idx + 1);
    }

    public static int subStrAndParseInt(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end));
    }*/
}
