package tree;



import data.BinaryTreeNode;
import data.Pair;

import java.util.LinkedList;

/**
 * 计算二叉树的最短路径
 */
public class CalculateDeep {

    public int minDepth(BinaryTreeNode root) {
        int deep = 0;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 第一层只有一个子节点
        int levelChildCount = 1;
        while (!queue.isEmpty()) {
            deep++;
            Pair<Integer, Boolean> result = isEnd(queue, levelChildCount);
            levelChildCount = result.first;
            // 如果已经最终层级，那就统计出了深度
            if (result.second) {
                return deep;
            }
        }
        return deep;
    }

    private Pair<Integer, Boolean> isEnd(LinkedList<BinaryTreeNode> queue, int currentCount) {
        // 统计当前层级共有几个孩子节点
        int childCount = 0;
        // 是否已经是最终的层级
        boolean result = false;
        // 当前层级有几个孩子节点，就要遍历几次
        for (int i = 0; i < currentCount; i++) {
            BinaryTreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                // 当前层是最终的层级
                return new Pair(childCount, true);
            }
            if (node.left != null) {
                childCount++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                childCount++;
                queue.offer(node.right);
            }
        }
        return new Pair(childCount, result);
    }
}
