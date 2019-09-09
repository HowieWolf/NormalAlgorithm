package tree;

import data.TreeNode;

import java.util.*;

/**
 * leetcode 103 蛇形访问二叉树
 * 需要两个栈
 */
public class ForeachByLevelLikeSnake {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 结果
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        // 两个栈
        Deque<TreeNode> originStack = new LinkedList<>();
        Deque<TreeNode> targetStack = new LinkedList<>();
        originStack.push(root);
        boolean reverse = false;
        while (!originStack.isEmpty()) {
            TreeNode node = originStack.pop();
            level.add(node.val);
            // 放入下层访问的节点，但需要注意先放左节点还是先放右节点
            if (reverse) {
                if (node.right != null) {
                    targetStack.push(node.right);
                }
                if (node.left != null) {
                    targetStack.push(node.left);
                }
            } else {
                if (node.left != null) {
                    targetStack.push(node.left);
                }
                if (node.right != null) {
                    targetStack.push(node.right);
                }
            }
            // 一行结束
            if (originStack.isEmpty()) {
                result.add(level);
                level = new ArrayList<>();
                // 交换 origin 和 target
                Deque t = originStack;
                originStack = targetStack;
                targetStack = t;
                reverse = !reverse;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        ForeachByLevelLikeSnake test = new ForeachByLevelLikeSnake();
        test.zigzagLevelOrder(root);
    }
}
