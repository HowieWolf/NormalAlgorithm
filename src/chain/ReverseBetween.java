package chain;

import data.ListNode;

public class ReverseBetween {

    ListNode newHead = null;
    ListNode newTail = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        newHead = null;
        newTail = null;
        int index = 1;
        // 拼接 m 之前的
        while (index < m) {
            addToChain(head);
            head = head.next;
            index++;
        }
        // 反转
        ListNode reverseHead = null;
        ListNode reverseTail = null;
        ListNode current = null;
        while (index <= n) {
            current = head;
            head = head.next;
            current.next = reverseHead;
            reverseHead = current;

            if (reverseTail == null) {
                reverseTail = current;
            }
            index++;
        }
        // 连接 n 之后的
        addToChain(reverseHead);
        reverseTail.next = head;
        return newHead;
    }

    private void addToChain(ListNode node) {
        if (newTail == null) {
            newTail = node;
        } else {
            newTail.next = node;
            newTail = node;
        }
        if (newHead == null) {
            newHead = node;
        }
    }
}
