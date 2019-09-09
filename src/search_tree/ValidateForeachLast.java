package search_tree;

/**
 * 问题描述
 * 给定一个数组，判断该数组是不是一颗二叉搜索树的后序遍历
 * <p>
 * 思路：
 * 后序遍历，最后一个节点是根节点，那么前面必定能分成两部分，一部分比根节点小，一部分比根节点小，然后递归判断
 * <p>
 * 拓展：
 * 判断是不是先序或中序
 * 中序直接判断数组是不是单调即可
 * 先序和后序思路相同
 */
public class ValidateForeachLast {

    public boolean validate(int[] data) {
        if (data == null) {
            return true;
        }
        return validateInner(data, 0, data.length);
    }

    private boolean validateInner(int[] data, int start, int len) {
        if (len < 2) {
            return true;
        }
        int root = data[start + len - 1];
        int leftLen = 0;
        // 从左开始扫描，找到右子树的起点
        for (; leftLen < len - 1; leftLen++) {
            if (data[start + leftLen] >= root) {
                break;
            }
        }
        for (int i = leftLen + start; i < len - 1; i++) {
            if (data[i] <= root) {
                return false;
            }
        }
        return validateInner(data, start, leftLen) && validateInner(data, start + leftLen, len - leftLen - 1);
    }

    public static void main(String[] args) {
        ValidateForeachLast test = new ValidateForeachLast();
        boolean validate = test.validate(new int[]{2,3,4});
        System.out.println(validate);
    }
}
