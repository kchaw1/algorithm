package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        String[] words = new String[size];

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();

            String word = words[i];
            boolean isOk = true;
            for (int j = 0; j < words[i].length(); j++) {
                String first = String.valueOf(word.charAt(0));

                String sub = word.replaceFirst(first, "");
                int find = sub.indexOf(first);
                if(find != -1 && find != 0) {
                    isOk = false;
                    break;
                } else {
                    word = sub;
                }
            }
            if(isOk) count++;
        }

        System.out.println(count);
    }
}
