package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 114
 * 给定一个二叉树，原地将它展开为链表。
 * 先序转换，要求左孩子 null，右孩子为 next
 */
public class TreeFlatten {

    private TreeNode result;
    private TreeNode tail;

    public void flattenRecursive(TreeNode root) {
        if (root == null){
            return;
        }
        flattenInner(root, null);
    }

    /**
     * 递归实现
     * 思想：先将右孩子 flatten，然后将左孩子 flatten，
     * 注意要将左孩子 flatten 后的最后一个节点指向右孩子的第一个节点
     * 然后 root 节点右孩子指向左孩子，左孩子置空
     *
     * @param next 指当前 root flatten 后，最后一个节点指向的下一个节点
     */
    private void flattenInner(TreeNode root, TreeNode next) {
        if (root.left == null && root.right == null) {
            root.right = next;
            return;
        }
        if (root.right != null) {
            // 要将 next 传递下去
            flattenInner(root.right, next);
        }
        if (root.left != null) {
            // 如果右子树 null，要将 next 传递下去
            flattenInner(root.left, root.right == null ? next : root.right);
            // 左子树 no null 要进行清空操作
            root.right = root.left;
            root.left = null;
        }
    }

    /**
     * 非递归实现
     * 思想：先序遍历，将节点的左孩子作为 next 指针。（因为此时右孩子还未遍历，不能变动
     * 遍历完成后，从头遍历一遍，将右孩子作为 next 指针，左孩子置空
     */
    public void flattenNoRecursive(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                root = root.right;
            } else {
                addNode(root);
                stack.push(root);
                root = root.left;
            }
        }
        adjust();
    }

    private void adjust() {
        while (result != null) {
            result.right = result.left;
            result.left = null;
            result = result.right;
        }
    }

    private void addNode(TreeNode node) {
        if (tail == null) {
            tail = node;
        } else {
            tail.left = node;
            tail = node;
        }
        if (result == null) {
            result = node;
        }
    }

    public static void main(String[] args) {
        TreeSerializationAndDeserialization util = new TreeSerializationAndDeserialization();
        TreeNode tree = util.doDeserialization("1,2,5,3,4,,6");
        TreeFlatten test = new TreeFlatten();
        test.flattenRecursive(tree);
        String result = util.doSerialization(tree);
        System.out.println(result);
    }
}
