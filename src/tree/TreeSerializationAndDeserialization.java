package tree;

import utils.QueueUtils;

import java.util.Queue;

/**
 * 树的序列化和反序列化
 * 采用广度优先序列化和反序列化
 */
public class TreeSerializationAndDeserialization {

    public String doSerialization(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        // 准备
        Queue<TreeNode> queue = QueueUtils.newQueue();
        queue.offer(root);
        builder.append(root.val);
        // 遍历
        while (!queue.isEmpty()) {
            root = queue.poll();
            // 空节点忽略
            if (root == null) {
                continue;
            }
            // 但空孩子要如队列占位
            addNode(queue, builder, root.left);
            addNode(queue, builder, root.right);
        }
        return builder.toString();
    }

    private void addNode(Queue<TreeNode> queue, StringBuilder builder, TreeNode node) {
        builder.append(",");
        if (node != null) {
            builder.append(node.val);
        }
        queue.offer(node);
    }

    public TreeNode doDeserialization(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] data = str.split(",");
        Queue<TreeNode> queue = QueueUtils.newQueue();
        TreeNode root = null;
        for (int i = 0; i < data.length; ) {
            if (root == null) {
                root = newNode(data[i++]);
                queue.offer(root);
            } else {
                TreeNode current = queue.poll();
                // 补充左孩子
                TreeNode node = newNode(data[i++]);
                if (node != null) {
                    current.left = node;
                    queue.offer(node);
                }
                // 补充右孩子
                if (i < data.length) {
                    node = newNode(data[i++]);
                    if (node != null) {
                        current.right = node;
                        queue.offer(node);
                    }
                }
            }
        }
        return root;
    }

    private TreeNode newNode(String d) {
        if (d == null || d.length() == 0 || "null".equals(d)) {
            return null;
        }
        TreeNode result = new TreeNode();
        result.val = Integer.parseInt(d);
        return result;
    }

    public static void main(String[] args) {
        TreeSerializationAndDeserialization test = new TreeSerializationAndDeserialization();
        TreeNode tree = test.doDeserialization("8,8,7,9,2,,,,,4,7");
        String str = test.doSerialization(tree);
        System.out.println(str);
    }
}
