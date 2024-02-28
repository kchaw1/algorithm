package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            sb.append(s.charAt(0));
            sb.append(s.charAt(s.length() - 1));
            if (i < n - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
