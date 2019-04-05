package tree;

import data.BinaryTreeNode;
import utils.QueueUtils;

import java.util.Queue;

public class MirrorTree {

    public void mirror(BinaryTreeNode<Integer> tree) {
        Queue<BinaryTreeNode<Integer>> queue = QueueUtils.newQueue(tree);
        BinaryTreeNode<Integer> c = null;
        while (!queue.isEmpty()) {
            c = queue.poll();
            swap(c);
            QueueUtils.addChildrenToQueue(queue, c);
        }
    }

    private void swap(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> t = node.left;
        node.left = node.right;
        node.right = t;
    }
}
