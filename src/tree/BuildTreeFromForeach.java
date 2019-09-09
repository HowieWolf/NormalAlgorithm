package tree;

import data.TreeNode;

/**
 * leetcode 889. 根据前序和后序遍历构造二叉树
 * <p>
 * 思想：
 * 后序遍历，最后一个数值一定是根节点
 * 前序遍历，第一个数值一定是根节点
 * 中序遍历，中间某个值是根节点，那左边的一定是左子树，右边的一定是右子树
 */
public class BuildTreeFromForeach {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) {
            return null;
        }
        return build(pre, post, 0, 0, pre.length);
    }

    private TreeNode build(int[] pre, int[] post, int preStart, int postStart, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (len == 1) {
            return root;
        }
        // 寻找左子树的长度
        int j = 1;
        // 在 pre 中找到右子树的起点，即可判断左子树的节点个数
        int rightRoot = post[postStart + len - 2];
        for (; j < len; j++) {
            if (pre[preStart + j] == rightRoot) {
                break;
            }
        }
        // 左子树的节点个数
        int leftLen = j - 1;
        root.left = build(pre, post, preStart + 1, postStart, leftLen);
        root.right = build(pre, post, preStart + j, postStart + leftLen, len - leftLen - 1);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeFromForeach test = new BuildTreeFromForeach();
        int[] pre = {2, 1, 3};
        int[] post = {3, 1, 2};
        TreeNode tree = test.constructFromPrePost(pre, post);
        System.out.println();
    }
}
