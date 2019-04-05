package chain;

import data.ListNode;
import utils.ChainUtils;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 构造一个虚拟头
        ListNode first = new ListNode(null);
        first.next = head;
        ListNode second = head.next;
        head = first;
        boolean inSame = false;
        while (second != null) {
            if (first.next.getData() == second.getData()) {
                inSame = true;
            } else if (inSame) {
                // 已经走过相同的区域，直接将相同区域删除
                // 这种情况下是不能确定 head
                first.next = second;
                inSame = false;
            } else {
                // 普通的情况，first, 后移一位
                first = first.next;
            }
            // 每次遍历，second 都会向后移动一位
            second = second.next;
        }
        // 如果一直到结尾都是相同的，那需要将 first.next 指定 null
        if (inSame) {
            first.next = null;
        }
        return head.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.getData()== head.next.next.getData()) {
                int val = (Integer)head.next.getData();
                while (head.next != null && (Integer)head.next.getData() == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> data = ChainUtils.newChain(new int[]{1, 1, 1, 2});
        DeleteDuplication test = new DeleteDuplication();
        ListNode result = test.deleteDuplication(data);
        System.out.println(ChainUtils.toString(result));
    }
}
