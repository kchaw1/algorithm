package leetcode;

public class Q2 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        boolean isPrevGreaterThanTen = false;
        while (l1 != null || l2 != null || isPrevGreaterThanTen) {
            int sum = isPrevGreaterThanTen ? 1 : 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum >= 10) {
                isPrevGreaterThanTen = true;
                sum %= 10;
            }  else {
                isPrevGreaterThanTen = false;
            }

            ListNode ln = new ListNode(sum);
            temp.next = ln;
            temp = ln;
        }

        return result.next;
    }
}
