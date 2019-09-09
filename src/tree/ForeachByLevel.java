package tree;

import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 102
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class ForeachByLevel {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // null 作为一行结束的标识
            if (node == null) {
                result.add(current);
                current = new ArrayList<>();
                // 一行遍历结束，需要在队列中添加一个结束标识符，但如果已经遍历结束，就不加了
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                continue;
            }
            current.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        ForeachByLevel test = new ForeachByLevel();
        test.levelOrder(root);
    }
}
