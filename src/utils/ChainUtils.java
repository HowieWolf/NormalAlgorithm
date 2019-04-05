package utils;

import data.ListNode;

public class ChainUtils {

    public static ListNode<Integer> newChain(int limit, int start, int step) {
        int count = 0;
        ListNode<Integer> head = new ListNode<>(start);
        ListNode current = head;
        count++;
        start += step;
        for (; count < limit; start += step, count++) {
            ListNode<Integer> node = new ListNode<>(start);
            current.next = node;
            current = node;
        }
        return head;
    }

    public static ListNode<Integer> newChain(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ListNode<Integer> head = null;
        ListNode<Integer> tail = null;
        for (int d : data) {
            ListNode t = new ListNode(d);
            if (tail == null) {
                tail = t;
            } else {
                tail.next = t;
                tail = t;
            }
            if (head == null) {
                head = t;
            }
        }
        return head;
    }

    public static String toString(ListNode<Integer> head) {
        StringBuilder builder = new StringBuilder();
        ListNode<Integer> current = head;
        while (current != null) {
            builder.append(current.getData());
            if ((current = current.next) != null) {
                builder.append("==>");
            }
        }
        return builder.toString();
    }
}
