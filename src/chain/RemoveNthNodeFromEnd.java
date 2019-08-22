package chain;

/**
 * leetcode 19 删除倒数第n个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 思路
 * 两个指针，一前一后，后面的距离签名的距离为 n
 * 极限情况，删除最后一个，删除第一个
 *
 * 从此题变换出来的简单的题目是找出倒数第 n 个节点，这样不需要设前置节点。
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode current = preHead;
        // 指向要删除节点的前一个节点
        ListNode tail = null;
        int count = 0;
        while (current.next != null) {
            if (tail != null) {
                current = current.next;
                tail = tail.next;
                continue;
            }
            if (++count >= n) {
                tail = preHead;
            }
            current = current.next;
        }
        // n 未超过链表的长度，找到了要删除的节点
        if (tail != null) {
            tail.next = tail.next.next;
        }
        // 如果删除的是正数第一个，需要将 head 指针替换
        if (tail == preHead) {
            head = preHead.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd test = new RemoveNthNodeFromEnd();
        ListNode chain = ChainUtils.newChain(1, 1, 1);
        System.out.println(ChainUtils.toString(chain));
        ListNode newChain = test.removeNthFromEnd(chain, 1);
        System.out.println(ChainUtils.toString(newChain));
    }
}
