package baekjoon.stepbystep.math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9020 {

    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        getPrime();

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());

            int a = num / 2;
            int b = num / 2;
            while (true) {
                if (!arr[a] && !arr[b]) {
                    sb.append(a).append(" ").append(b).append("\n");
                    break;
                } else {
                    a--;
                    b++;
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void getPrime() {
        arr[0] = arr[1] = true;

        for (int j = 2; j * j <= 10000; j++) {
            if (!arr[j]) {
                for (int k = j * j; k <= 10000; k += j) {
                    arr[k] = true;
                }
            }
        }
    }
}
    /*
    // 1차로 푼 코드
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(sc.nextLine());

            int result = 0;
            int prevGap = -1;
            for (int j = 0; j <= num; j++) {
                if(isPrime(j)) {
                    int sub = num - j;
                    if (isPrime(sub)) {
                        int gap = Math.abs(j - sub);
                        if(prevGap == -1) {
                            prevGap = gap;
                            result = j;
                        } else if (gap < prevGap){
                            prevGap = gap;
                            result = j;
                        }
                    }
                }
            }

            if (result < num - result) {
                sb.append(result).append(" ").append(num - result);
            } else {
                sb.append(num - result).append(" ").append(result);
            }

            if(i != size-1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean isPrime(int num) {
        for (int j = 2; j*j <= num; j++) {
            if(num % j == 0) return false;
        }
        return true;
    }*/
