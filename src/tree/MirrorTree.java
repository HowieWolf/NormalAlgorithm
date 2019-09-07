package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 226
 * 反转二叉树，镜像二叉树
 * 广度优先遍历，交换左右节点
 */
public class MirrorTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swapChild(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    private void swapChild(TreeNode node) {
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
    }
}
