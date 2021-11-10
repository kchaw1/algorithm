import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {

        String regex = "(a*)|([a-z])";

        String s = "aaaaaaaaaaaaaabcaaa";

        System.out.println(s.matches(regex));
    }
}
