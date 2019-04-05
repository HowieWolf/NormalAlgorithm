package utils;

import data.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUtils {

    public static <D> Queue<D> newQueue(D... datas) {
        Queue<D> queue = new LinkedList<>();
        for (D d : datas) {
            queue.offer(d);
        }
        return queue;
    }

    public static <D> void addChildrenToQueue(Queue<BinaryTreeNode<D>> q, BinaryTreeNode<D> node) {
        if (node.left != null) {
            q.offer(node.left);
        }
        if (node.right != null) {
            q.offer(node.right);
        }
    }
}
