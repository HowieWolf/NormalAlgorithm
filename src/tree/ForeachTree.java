package tree;

import data.BinaryTreeNode;
import utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ForeachTree {

    private BinaryTreeNode<Integer> root;

    /**
     * 广度优先遍历
     */
    public void foreachWidthly() {
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeNode<Integer> head = null;
        while ((head = queue.poll()) != null) {
            System.out.println(head.getData());
            queue.offer(head.left);
            queue.offer(head.right);
        }
    }

    /**
     * 先序遍历
     * 与中序遍历形成对比，仅仅是输出的时机不同
     */
    public void foreachFirst1() {
        LinkedList<BinaryTreeNode<Integer>> stack1 = new LinkedList<>();
        BinaryTreeNode<Integer> current = root;
        while (current != null || !stack1.isEmpty()) {
            if (current == null) {
                current = stack1.pop().right;
            } else {
                System.out.println(current.getData());
                stack1.push(current);
                current = current.left;
            }
        }
    }

    /**
     * 中序遍历
     */
    public void foreachMiddle() {
        LinkedList<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        BinaryTreeNode<Integer> current = root;
        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                current = stack.pop();
                System.out.println(current.getData());
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void foreachLast() {
    }

    public ForeachTree(BinaryTreeNode<Integer> root) {
        this.root = root;
    }

    public static void main(String... args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.newBinaryTree(7);
        ForeachTree tree = new ForeachTree(root);
        System.out.println();
    }
}
