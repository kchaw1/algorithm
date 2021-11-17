package codeplus.algorithm.basic1;

import java.util.Scanner;

public class Q1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
    }
}