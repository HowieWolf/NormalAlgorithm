package tree;

import data.BinaryTreeNode;
import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtils2 {

    public static TreeNode newBinaryTree(int limit) {
        if (limit < 1) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int current = 0;
        TreeNode root = new TreeNode(current++);
        queue.offer(root);
        while (current < limit) {
            TreeNode head = queue.poll();
            // 添加左节点
            TreeNode newNode = new TreeNode(current++);
            queue.offer(newNode);
            head.left = newNode;
            // 判长度
            if (current >= limit) {
                break;
            }
            // 添加右节点
            newNode = new TreeNode(current++);
            queue.offer(newNode);
            head.right = newNode;
        }
        return root;
    }

    /**
     * 使用广度优先的方式构造树
     *
     * @param data
     * @return
     */
    public static TreeNode newBinaryTree(Integer[] data) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tree = null;
        TreeNode current = null;
        for (int i = 0; i < data.length; ) {
            TreeNode node = null;
            Integer d = null;
            if (tree == null) {
                d = data[i++];
                node = newNode(d);
                tree = node;
                queue.offer(node);
            } else {
                current = queue.poll();
                if (i < data.length) {
                    d = data[i++];
                    node = newNode(d);
                    current.left = node;
                    queue.offer(node);
                } else {
                    return tree;
                }
                if (i < data.length) {
                    d = data[i++];
                    node = newNode(d);
                    current.right = node;
                    queue.offer(node);
                } else {
                    return tree;
                }
            }
        }
        return tree;
    }

    public static TreeNode newNode(Integer data) {
        return data == null ? null : new TreeNode(data);
    }

    public static String toStringAsDeque(BinaryTreeNode<Integer> tree) {
        StringBuilder builder = new StringBuilder();
        while (tree != null) {
            builder.append(tree.getData());
            if (tree.right != null) {
                builder.append("==>");
            }
            tree = tree.right;
        }
        return builder.toString();
    }
}
