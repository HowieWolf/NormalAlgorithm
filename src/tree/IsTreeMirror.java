package tree;

import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 101
 * 判断一颗树是否是对称的二叉树
 */
public class IsTreeMirror {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root);
        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.right);
            q2.offer(n2.left);
        }
        return true;
    }
}
