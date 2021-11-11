package baekjoon.stepbystep.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1712 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int fixCost = Integer.parseInt(st.nextToken());
        int variableCost = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        if (variableCost > price || price-variableCost == 0) {
            System.out.println(-1);
        } else {
            System.out.println(fixCost / (price - variableCost) + 1);
        }
    }
}
