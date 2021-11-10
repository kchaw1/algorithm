package baekjoon.stepbystep.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
public class Q11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a =  sc.next();

        System.out.println((int)a.charAt(0));
    }
}
