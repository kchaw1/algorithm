package leetcode;

public class Q7 {
    public static void main(String[] args) {
        Q7 q = new Q7();
        System.out.println(q.reverse(1534236469));
    }

    public int reverse(int x) {
        String s = String.valueOf(x);

        String[] arr = s.split("");

        boolean isNegative = false;

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                if(arr[i].equals("-")) {
                    isNegative = true;
                } else {
                    sb.append(arr[i]);
                }
            } else {
                sb.append(arr[i]);
            }
        }

        int result = 0;

        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
        }
        return isNegative ? result * -1 : result;
    }
}
