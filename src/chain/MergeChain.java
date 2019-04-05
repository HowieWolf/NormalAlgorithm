package chain;

import data.ListNode;
import utils.ChainUtils;

/**
 * 合并有序单链表
 */
public class MergeChain {
    private ListNode<Integer> c1;
    private ListNode<Integer> c2;

    public ListNode<Integer> merge() {
        ListNode<Integer> merged = null;
        ListNode<Integer> tail = merged;
        while (c1 != null || c2 != null) {
            ListNode<Integer> current = getMergeNode();
            if (merged == null) {
                merged = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }
        return merged;
    }

    private ListNode<Integer> getMergeNode() {
        ListNode<Integer> current;
        if (c2 == null) {
            // c1 != null
            current = moveC1();
        } else if (c1 == null) {
            // c2 != null
            current = moveC2();
        } else if (c2.getData() < c1.getData()) {
            current = moveC2();
        } else {
            current = moveC1();
        }
        return current;
    }

    private ListNode<Integer> moveC1() {
        ListNode<Integer> head = c1;
        c1 = c1.next;
        return head;
    }

    private ListNode<Integer> moveC2() {
        ListNode<Integer> head = c2;
        c2 = c2.next;
        return head;
    }

    public static void main(String[] args) {
        MergeChain p = new MergeChain();
        p.c1 = ChainUtils.newChain(5, 0, 2);
        p.c2 = ChainUtils.newChain(5, 1, 3);
        System.out.println(ChainUtils.toString(p.c1));
        System.out.println(ChainUtils.toString(p.c2));
        ListNode<Integer> result = p.merge();
        System.out.println(ChainUtils.toString(result));
    }

}
