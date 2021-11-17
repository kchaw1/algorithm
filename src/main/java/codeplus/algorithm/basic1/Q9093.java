package codeplus.algorithm.basic1;

import java.util.Scanner;

public class Q9093 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        String[] result = new String[size];

        for(int h =0; h < size; h++) {
            String sentence = sc.nextLine();

            StringBuilder sb = new StringBuilder();

            String[] arr1 = sentence.split(" ");

            for (int i = 0; i < arr1.length; i++) {
                String[] arr2 = arr1[i].split("");

                for (int j = arr2.length - 1; j >= 0; j--) {
                    sb.append(arr2[j]);
                }

                if (i != arr1.length - 1) {
                    sb.append(" ");
                }
            }

            result[h] = sb.toString();
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
