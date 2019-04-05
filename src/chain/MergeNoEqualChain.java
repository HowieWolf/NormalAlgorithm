package chain;

import data.ListNode;
import utils.ChainUtils;

/**
 * 合并有序不重复单链表
 * 要求合并后也不能重复
 */
public class MergeNoEqualChain {

    private ListNode<Integer> result;
    private ListNode<Integer> tail;

    public void merge(ListNode<Integer> c1, ListNode<Integer> c2) {
        clean();
        while (c1 != null || c2 != null) {
            // 其中一条链为 null
            if (c1 == null) {
                mergeToTail(c2);
                return;
            }
            if (c2 == null) {
                mergeToTail(c1);
                return;
            }
            // 对比两条链的头节点
            ListNode<Integer> currentNode;
            if (c1.getData() < c2.getData()) {
                currentNode = c1;
                c1 = c1.next;
            } else if (c1.getData() > c2.getData()) {
                currentNode = c2;
                c2 = c2.next;
            } else {
                // 如果两个头节点相等
                currentNode = c1;
                c1 = c1.next;
                c2 = c2.next;
            }
            currentNode.next = null;
            // 将 merge 节点合入结果
            mergeToTail(currentNode);
        }
    }

    private void clean() {
        result = null;
        tail = null;
    }

    private void mergeToTail(ListNode<Integer> c) {
        if (result == null) {
            result = c;
        }
        if (tail == null) {
            tail = c;
        } else {
            tail.next = c;
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        MergeNoEqualChain p = new MergeNoEqualChain();
        ListNode<Integer> c1 = ChainUtils.newChain(5, 0, 2);
        System.out.println(ChainUtils.toString(c1));
        ListNode<Integer> c2 = ChainUtils.newChain(5, 1, 2);
        System.out.println(ChainUtils.toString(c2));
        p.merge(c1, c2);
        System.out.println(ChainUtils.toString(p.result));
    }
}
