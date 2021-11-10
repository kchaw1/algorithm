package baekjoon.stepbystep.string;

import java.util.Scanner;

public class Q2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); // ljes=njak

        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < arr.length; i++) {
            s= s.replace(arr[i], " ");
        }

        System.out.println(s.length());
    }
}
