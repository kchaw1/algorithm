package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        Q6 q = new Q6();
        System.out.println(q.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new String[s.length()]);
        }

        int pos = 0;
        int idx = 0;
        boolean toggle = true;
        while (pos < s.length()) {
            if (idx == 0) {
                toggle = true;
            } else if (idx == list.size() - 1) {
                toggle = false;
            }
            String[] arr = list.get(idx);
            arr[pos] = s.substring(pos, pos + 1);

            if (list.size() > 1) {
                if (toggle) {
                    idx++;
                } else {
                    idx--;
                }
            }
            pos++;
        }

        StringBuilder sb = new StringBuilder();
        for (String[] arr : list) {
            Arrays.stream(arr).forEach(ss -> {
                if(ss != null) sb.append(ss);
            });
        }
        return sb.toString();
    }
}
