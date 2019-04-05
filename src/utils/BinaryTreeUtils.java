package utils;

import data.BinaryTreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtils {

    public static BinaryTreeNode<Integer> newBinaryTree(int limit) {
        if (limit < 1) {
            return null;
        }
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        int current = 0;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(current++);
        queue.offer(root);
        while (current < limit) {
            BinaryTreeNode<Integer> head = queue.poll();
            // 添加左节点
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(current++);
            queue.offer(newNode);
            head.left = newNode;
            // 判长度
            if (current >= limit) {
                break;
            }
            // 添加右节点
            newNode = new BinaryTreeNode<>(current++);
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
    public static <D> BinaryTreeNode<D> newBinaryTree(D[] data) {
        Queue<BinaryTreeNode<D>> queue = new LinkedList<>();
        BinaryTreeNode<D> tree = null;
        BinaryTreeNode<D> current = null;
        for (int i = 0; i < data.length; ) {
            BinaryTreeNode<D> node = null;
            D d = null;
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

    public static <D> BinaryTreeNode<D> newNode(D data) {
        return data == null ? null : new BinaryTreeNode<>(data);
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
