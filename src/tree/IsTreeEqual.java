package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 100
 * 判断两颗二叉树是否相等
 */
public class IsTreeEqual {
    public boolean isTreeEqualsRecursive(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (!isNodeEqual(one, two)) {
            return false;
        }
        return isTreeEqualsRecursive(one.left, two.left) && isTreeEqualsRecursive(one.right, two.right);
    }

    public boolean isTreeEqualNorecursive(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(one);
        q2.offer(two);
        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (!isNodeEqual(n1, n2)) {
                return false;
            }
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.left);
            q2.offer(n2.right);
        }
        return true;
    }

    private boolean isNodeEqual(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return false;
        }
        if (one.val != two.val) {
            return false;
        }
        if (one.left == null && two.left != null) {
            return false;
        }
        if (one.left != null && two.left == null) {
            return false;
        }
        if (one.right == null && two.right != null) {
            return false;
        }
        if (one.right != null && two.right == null) {
            return false;
        }
        return true;
    }
}
