package tree;

import data.TreeNode;

/**
 * 递归遍历二叉树
 * <p>
 * 注意：广度优先遍历没有递归实现
 */
public class ForeachTreeRecursive {

    /**
     * 先序
     *
     * @param root
     */
    public void foreachFirst(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        foreachFirst(root.left);
        foreachFirst(root.right);
    }

    public void foreachMiddle(TreeNode root) {
        if (root == null) {
            return;
        }
        foreachMiddle(root.left);
        System.out.print(root.val + "\t");
        foreachMiddle(root.right);
    }

    public void foreachLast(TreeNode root) {
        if (root == null) {
            return;
        }
        foreachLast(root.left);
        foreachLast(root.right);
        System.out.print(root.val + "\t");
    }
}
