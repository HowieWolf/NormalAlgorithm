package chain;


public class ChainUtils {

    public static ListNode newChain(int limit, int start, int step) {
        int count = 0;
        ListNode head = new ListNode(start);
        ListNode current = head;
        count++;
        start += step;
        for (; count < limit; start += step, count++) {
            ListNode node = new ListNode(start);
            current.next = node;
            current = node;
        }
        return head;
    }

    public static ListNode newChain(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
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

    public static String toString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            builder.append(current.val);
            if ((current = current.next) != null) {
                builder.append("==>");
            }
        }
        return builder.toString();
    }
}
