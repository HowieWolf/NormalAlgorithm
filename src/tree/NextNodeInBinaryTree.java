package tree;

import data.TreeNode;

/**
 * 给定一个二叉树和其中一个节点，找出中序遍历的下一个节点。节点有一个指向父节点的指针
 * <p>
 * 思考：
 * 1）当前节点有右孩子，那么下个节点就是以右孩子为根的树的最左孩子节点；
 * 2）当前节点没有右孩子，且没有父节点，那么没有下个节点；
 * 3）当前节点没有右孩子，作为父节点的左孩子，那么下个节点就是父节点；
 * 4）当前节点没有右孩子，作为父节点的右孩子，那么下个节点是当前节点的祖先中作为做孩子节点的父节点
 * <p>
 * <p>
 * 拓展思考：
 * 如果是后序遍历
 * 1）当前节点没有父节点，那么没有下个节点；
 * 2）当前节点是父节点的右孩子，那么下个节点就是父节点；
 * 3）当前节点是父节点的左孩子，且没有兄弟节点，那么下个节点就是父节点；
 * 4）当前节点是父节点的左孩子，但有兄弟节点，那么下个节点就是以兄弟节点作为根的树的最左孩子节点
 * <p>
 * <p>
 * 如果是先序遍历
 * 1）当前节点有左孩子，那么下个节点就是左孩子节点；
 * 2）当前节点无左孩子，有右孩子，那么下个节点就是右孩子节点；
 * 3）当前节点无孩子节点，也无父节点，那么无下个节点；
 * 4）当前节点无孩子节点，作为左孩子节点且有兄弟节点，那么下个节点是其兄弟节点；
 * 5）当前节点无孩子节点，作为左孩子但无兄弟节点 或 作为右孩子，那么下个节点是当前节点的祖先中作为左孩子节点的兄弟节点
 */
public class NextNodeInBinaryTree {

    public TreeNode nextNodeInMiddle(TreeNode target) {
        if (target == null) {
            return null;
        }
        if (target.right != null) {
            return findLeftestChild(target.right);
        } else if (target.parent == null) {
            return null;
        } else if (target.parent.left == target) {
            return target.parent;
        } else {
            return findParentAsLeftChild(target.parent);
        }
    }

    private TreeNode findLeftestChild(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode findParentAsLeftChild(TreeNode node) {
        while (node != null) {
            TreeNode parent = node.parent;
            if (parent == null || parent.right == node) {
                node = parent;
            } else {
                return parent;
            }
        }
        return node;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        a.left = b;
        b.parent = a;


        TreeNode d = new TreeNode('d');
        b.left = d;
        d.parent = b;

        TreeNode e = new TreeNode('e');
        b.right = e;
        e.parent = b;

        TreeNode h = new TreeNode('h');
        TreeNode i = new TreeNode('i');
        e.left = h;
        h.parent = e;
        e.right = i;
        i.parent = e;

        TreeNode c = new TreeNode('c');
        a.right = c;
        c.parent = a;

        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        c.left = f;
        f.parent = c;
        c.right = g;
        g.parent = c;

        NextNodeInBinaryTree test = new NextNodeInBinaryTree();
        System.out.println((char)test.nextNodeInMiddle(a).val);
        System.out.println((char)test.nextNodeInMiddle(b).val);
        System.out.println((char)test.nextNodeInMiddle(c).val);
        System.out.println((char)test.nextNodeInMiddle(d).val);
        System.out.println((char)test.nextNodeInMiddle(e).val);
        System.out.println((char)test.nextNodeInMiddle(f).val);
//        System.out.println((char)test.nextNodeInMiddle(g).val);
        System.out.println((char)test.nextNodeInMiddle(h).val);
        System.out.println((char)test.nextNodeInMiddle(i).val);
    }

}
