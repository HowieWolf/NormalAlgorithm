package chain;

/**
 * leetcode 21 合并有序单链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeChain {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 引入一个 pre 的头结点，可减少一些判空
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            // 如果有链表为空，则可直接结束
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }
            // 找出要合并的节点
            ListNode current;
            if (l1.val > l2.val) {
                current = l2;
                l2 = l2.next;
            } else {
                current = l1;
                l1 = l1.next;
            }
            // 清空 current.next
            current.next = null;
            tail.next = current;
            tail = current;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeChain p = new MergeChain();
        ListNode c1 = ChainUtils.newChain(5, 0, 2);
        ListNode c2 = ChainUtils.newChain(5, 1, 3);
        System.out.println(ChainUtils.toString(c1));
        System.out.println(ChainUtils.toString(c2));
        ListNode result = p.mergeTwoLists(null, c2);
        System.out.println(ChainUtils.toString(result));
    }
}
