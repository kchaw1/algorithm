package baekjoon.stepbystep.math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Q3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double r = Double.parseDouble(br.readLine());

        DecimalFormat df = new DecimalFormat("#.######");

        String sb = df.format(Math.pow(r, 2) * Math.PI) +
                "\n" +
                df.format(Math.pow(r, 2d) * 2d);
        System.out.println(sb);
    }
}
