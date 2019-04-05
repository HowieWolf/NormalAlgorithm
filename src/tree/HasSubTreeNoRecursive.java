package tree;

import data.BinaryTreeNode;
import utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 非递归遍历每个节点，判断当前节点是否存在子树关系
 */
public class HasSubTreeNoRecursive {

    public boolean hasSubTree(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> sub) {
        if (tree == null || sub == null) {
            return false;
        }
        Queue<BinaryTreeNode<Integer>> queue = newQueue(tree);
        while (!queue.isEmpty()) {
            tree = queue.poll();
            if (isSame(tree, sub)) {
                return true;
            }
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
        }
        return false;
    }

    /**
     * 两棵树是否是定点相同的子树关系
     * @param t1
     * @param t2
     * @return
     */
    private boolean isSame(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
        Queue<BinaryTreeNode<Integer>> q1 = newQueue(t1);
        Queue<BinaryTreeNode<Integer>> q2 = newQueue(t2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            t1 = q1.poll();
            t2 = q2.poll();
            if (t1.getData() != t2.getData()) {
                return false;
            }
            addToQueue(q1, t1);
            addToQueue(q2, t2);
        }
        return q2.isEmpty();
    }

    private void addToQueue(Queue<BinaryTreeNode<Integer>> queue, BinaryTreeNode<Integer> node) {
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
    }

    private Queue<BinaryTreeNode<Integer>> newQueue(BinaryTreeNode<Integer> node) {
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(node);
        return queue;
    }

    public static void main(String[] args) {
        Integer[] treeData = new Integer[]{8, 8, 7, 9, 2, null, null, null, null, 4, 7};
        BinaryTreeNode<Integer> tree = BinaryTreeUtils.newBinaryTree(treeData);
        treeData = new Integer[]{2, 4, 7, 4};
        BinaryTreeNode<Integer> sub = BinaryTreeUtils.newBinaryTree(treeData);
        HasSubTreeNoRecursive test = new HasSubTreeNoRecursive();
        boolean result = test.hasSubTree(tree, sub);
        System.out.println(result);
    }
}
