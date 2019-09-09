package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leecode 946
 * 给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 思路：
 * 模拟出入栈的操作。
 * 如果当前栈顶不是出栈元素，则需要元素入栈，直到找到出栈的元素，如果找不到，那就失败
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || popped.length == 0) {
            return true;
        }
        if (pushed == null || pushed.length == 0) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < popped.length; ) {
            if (stack.isEmpty() || stack.peek() != popped[i]) {
                // 入栈队列中没有要找的元素
                if (index >= pushed.length) {
                    return false;
                }
                stack.push(pushed[index++]);
            } else {
                // 栈顶找到了出栈元素，继续下一个元素
                stack.pop();
                i++;
            }
        }
        return true;
    }
}
