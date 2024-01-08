package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> store = new ArrayList<>();

        createListFromListNode(store, list1);
        createListFromListNode(store, list2);

        store.sort(Comparator.naturalOrder());

        if (store.isEmpty()) {
            return null;
        }

        ListNode result = new ListNode(store.getFirst());
        createListNode(store, result, 1);

        return result;
    }

    private void createListNode(List<Integer> store, ListNode node, int index) {
        if (index == store.size()) {
            return;
        }
        ListNode nextNode = new ListNode(store.get(index));
        node.next = nextNode;
        createListNode(store, nextNode, ++index);
    }


    private void createListFromListNode(List<Integer> store, ListNode listNode) {
        if (listNode == null) {
            return;
        }

        store.add(listNode.val);
        if (listNode.next == null) {
            return;
        }
        createListFromListNode(store, listNode.next);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
