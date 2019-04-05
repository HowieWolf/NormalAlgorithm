package tree;

import data.BinaryTreeNode;

/**
 * 判断两棵树是否是子树关系
 */
public class HasSubTreeRecursive {

    public boolean hasSubTree(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> sub) {
        if (sub == null || tree == null) {
            return false;
        }
        // 递归的思路是 当前两个树是否相同 或 它是不是左子树的子树 或 它是不是右子树的子树
        return isSame(tree, sub) || hasSubTree(tree.left, sub) || hasSubTree(tree.right, sub);
    }

    /**
     * 两个节点是否相同
     * @param n1
     * @param n2
     * @return
     */
    private boolean isSame(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        if (n2 == null) return true;
        if (n1 == null) return false;
        // 两者均不为 null
        return n1.getData() == n2.getData() && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }


}
