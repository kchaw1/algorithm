import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        while (st.hasMoreElements()) {
//            System.out.println(st.nextToken());
//        }

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println(sc.nextLine());
        }
    }
}
