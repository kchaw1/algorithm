package baekjoon.stepbystep.string;

import java.util.Scanner;

public class Q5622 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] arr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        String[] split = input.split("");

        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            for (int j = 0; j < arr.length; j++) {
                if(arr[j].contains(s)) {
                    result += (j+2)+1;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
