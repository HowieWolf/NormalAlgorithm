package tree;

import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 非递归遍历二叉树
 *
 * 注意：未实现后序遍历
 */
public class ForeachTreeNoRecursive {

    public void foreachFirst(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            if (current == null) {
                current = stack.pop();
                current = current.right;
            } else {
                System.out.print(current.val + "\t");
                stack.push(current);
                current = current.left;
            }
        }
    }

    public void foreachMiddle(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            if (current == null) {
                current = stack.pop();
                System.out.print(current.val + "\t");
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
    }

    public void foreachWidthly(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + "\t");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}
