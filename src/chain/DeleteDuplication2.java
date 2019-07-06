package chain;

import data.ListNode;
import utils.ChainUtils;

/**
 * LeetCode 82
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication2 {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 构造一个虚拟的前置头结点
        ListNode pre = new ListNode(null);
        pre.next = head;

        // 初始化两个指针
        ListNode current = pre;
        ListNode next = head;

        // 标识现在是否处于相同的阶段
        boolean isInSame = false;

        while (next.next != null){
            // 如果两个节点值相同，直接后移next指针，并设标志位
            if (current.next.getData() == next.next.getData()){
                next = next.next;
                isInSame = true;
                continue;
            }
            // 不相同
            if (isInSame){
                // 此时前面有相同节点，应该删除
                current.next = next.next;
                next = next.next;
            } else {
                // 相邻两个节点，直接后移
                current = next;
                next = next.next;
            }
        }
        // 如果最后几个节点都相同，需要直接删除
        if (isInSame){
            current.next = null;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> data = ChainUtils.newChain(new int[]{1, 1, 1, 2});
        DeleteDuplication2 test = new DeleteDuplication2();
        ListNode result = test.deleteDuplication(data);
        System.out.println(ChainUtils.toString(result));
    }
}
