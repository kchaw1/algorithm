package programmers.level.level2;

public class Q12951 {
    public static void main(String[] args) {
        String s = " a b";
        String solution = solution(s);
        System.out.println(solution);
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String before = "";
        for (int i = 0; i < s.length(); i++) {
            String ss = String.valueOf(s.charAt(i));
            if (ss.equals(" ")) {
                sb.append(ss);
            } else {
                if (before.isBlank()) {
                    sb.append(ss.toUpperCase());
                } else {
                    sb.append(ss.toLowerCase());
                }
            }
            before = ss;
        }
        return sb.toString();
    }

//    String firstLetter = element.substring(0, 1).toUpperCase();
//    String extraLetter = element.substring(1).toLowerCase();
}
