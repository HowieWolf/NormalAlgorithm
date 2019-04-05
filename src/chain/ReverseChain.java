package chain;

import data.ListNode;
import utils.ChainUtils;

public class ReverseChain<D> {

    public void reverseNoRecursive(ListNode<D> head) {
        ListNode<D> currentNode = null;
        ListNode<D> newChain = null;
        while (head != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = newChain;
            newChain = currentNode;
        }
    }

    public static void main(String... args) {
        ListNode<Integer> head = ChainUtils.newChain(6, 1, 2);
        ReverseChain<Integer> chain = new ReverseChain<>();
        System.out.println(ChainUtils.toString(head));
        chain.reverseNoRecursive(head);
        System.out.println(ChainUtils.toString(head));
    }
}
