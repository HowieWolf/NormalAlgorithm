package chain;

import data.ListNode;
import utils.ChainUtils;

/**
 * leetcode 83
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->3->4->5
 */
public class DeleteDuplication1 {

    /**
     * 这种方法简单，但是有一个问题，比如连续两个以上相同元素，1,2,3,3,3,3,4
     * 需要在3这个节点上处理很多次
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.getData() == current.next.getData()) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 这种方案就是一直找到不在重复的，才进行赋值
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        while(next != null){
            if(current.getData() != next.getData()){
                current.next = next;
                current = next;
                next = next.next;
            } else {
                next = next.next;
            }
        }
        current.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> data = ChainUtils.newChain(new int[]{1, 1, 1, 2});
        DeleteDuplication1 test = new DeleteDuplication1();
        ListNode result = test.deleteDuplicates1(data);
        System.out.println(ChainUtils.toString(result));
    }
}
