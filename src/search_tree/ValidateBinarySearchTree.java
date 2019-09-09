package search_tree;

import data.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 98. 验证二叉搜索树
 * <p>
 * 思路
 * 一、递归
 * 二、中序遍历，比较值是否递增
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        // 上一个节点
        TreeNode last = null;
        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                current = stack.pop();
                // 空，或满足递增关系，则 last 指向 current
                if (last == null || last.val < current.val) {
                    last = current;
                } else {
                    return false;
                }
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
        return true;
    }
}
