package tree;

import data.BinaryTreeNode;
import utils.BinaryTreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 将一个二叉树，中序转换为双向链表
 */
public class TreeToDeque {

    private BinaryTreeNode<Integer> result;
    private BinaryTreeNode<Integer> tail;

    /**
     * 非递归的转换
     *
     * @param root
     */
    public void toListNoRecursive(BinaryTreeNode<Integer> root) {
        clean();
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                addResult(root);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
    }

    private void addResult(BinaryTreeNode<Integer> n) {
        /**
         * 不能修改节点的右子树
         */
        if (result == null) {
            result = n;
        }
        if (tail == null) {
            tail = n;
        } else {
            tail.right = n;
            n.left = tail;
            tail = n;
        }
    }

    /**
     * 递归转换
     */
    public void toListRecursive(BinaryTreeNode<Integer> root) {
        clean();
        if (root == null) {
            return;
        }
        if (root.left != null) {
            toListRecursive(root.left);
        }
        addResult(root);
        if (root.right != null) {
            toListRecursive(root.right);
        }
    }

    private void clean(){
        result = null;
        tail = null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = BinaryTreeUtils.newBinaryTree(7);
        TreeToDeque test = new TreeToDeque();
        test.toListRecursive(tree);
        System.out.println(BinaryTreeUtils.toStringAsDeque(test.result));
    }
}
