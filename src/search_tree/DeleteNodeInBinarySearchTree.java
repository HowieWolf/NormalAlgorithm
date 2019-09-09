package search_tree;

import data.TreeNode;
import tree.TreeSerializationAndDeserialization;

/**
 * leetcode 450
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class DeleteNodeInBinarySearchTree {
    /**
     * 思路：
     * 当前节点不是目标值，就需要从左子树或右子树中删除，递归调用
     * 如果就是当前节点，需要分为 1)没有子树 2)有一个子树 3)两个子树都有的情况
     * 如果两个子树都有，那就需要将左子树放到右子树下，返回右子树（或相反）
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // root.val == key
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            add(root.right, root.left);
            return root.right;
        }
    }

    private void add(TreeNode target, TreeNode node) {
        while (target != null && node != null) {
            if (target.val == node.val) {
                target = null;
            } else if (target.val > node.val) {
                if (target.left == null) {
                    target.left = node;
                    target = null;
                } else {
                    target = target.left;
                }
            } else {
                if (target.right == null) {
                    target.right = node;
                    target = null;
                } else {
                    target = target.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeSerializationAndDeserialization utils = new TreeSerializationAndDeserialization();
        TreeNode tree = utils.doDeserialization("5,3,6,2,4,null,7");
        DeleteNodeInBinarySearchTree test = new DeleteNodeInBinarySearchTree();
        tree = test.deleteNode(tree, 3);
        System.out.println(utils.doSerialization(tree));
    }
}
