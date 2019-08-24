package chain;


/**
 * 合并有序不重复单链表
 * 要求合并后也不能重复
 * 思路：
 * 必须每个节点都需要遍历
 */
public class MergeNoEqualChain {

    public ListNode merge(ListNode c1, ListNode c2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // 当前重复的节点
        ListNode current = null;
        while (c1 != null || c2 != null) {
            // 重复节点需要首先清除，一次只清除一个
            if (current != null) {
                if (c2 != null && c2.val == current.val) {
                    c2 = c2.next;
                    continue;
                }
                if (c1 != null && c1.val == current.val) {
                    c1 = c1.next;
                    continue;
                }
            }
            // 找寻要添加的节点
            if (c1 == null) {
                current = c2;
                c2 = c2.next;
            } else if (c2 == null) {
                current = c1;
                c1 = c1.next;
            } else if (c1.val > c2.val) {
                current = c2;
                c2 = c2.next;
            } else {
                current = c1;
                c1 = c1.next;
            }
            // 判断是否能添加
            if (hasSame(current, c1, c2)) {
                continue;
            }
            // 加到链尾
            current.next = null;
            tail.next = current;
            tail = current;
            current = null;
        }
        return head.next;
    }

    private boolean hasSame(ListNode current, ListNode c1, ListNode c2) {
        if (c1 != null && c1.val == current.val) {
            return true;
        }
        return c2 != null && c2.val == current.val;
    }

    public static void main(String[] args) {
        MergeNoEqualChain p = new MergeNoEqualChain();
        ListNode c1 = ChainUtils.newChain(new int[]{2,3,4});
        System.out.println(ChainUtils.toString(c1));
        ListNode c2 = ChainUtils.newChain(new int[]{2,2});
        System.out.println(ChainUtils.toString(c2));
        ListNode result = p.merge(c1, c2);
        System.out.println(ChainUtils.toString(result));
    }
}
