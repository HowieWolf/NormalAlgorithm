package stack_queue;

/**
 * LeetCode 155
 * 实现一个栈，具有 min 功能，在 O(1) 时间内找出当前栈内最小的值
 */
class MinStack {
    private int[] data;
    private int[] min;
    private int index = -1;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new int[1];
        min = new int[1];
    }

    public void push(int x) {
        if (index >= data.length - 1) {
            resize();
        }
        int currentMin = index < 0 ? Integer.MAX_VALUE : min[index];
        index++;
        data[index] = x;
        min[index] = currentMin >= x ? x : currentMin;
    }

    private void resize() {
        int[] nData = new int[data.length << 1];
        int[] nMin = new int[data.length << 1];
        System.arraycopy(data, 0, nData, 0, data.length);
        System.arraycopy(min, 0, nMin, 0, min.length);
        this.data = nData;
        this.min = nMin;
    }

    public void pop() {
        if (index < 0) {
            return;
        }
        index--;
    }

    public int top() {
        if (index < 0) {
            throw new RuntimeException("");
        }
        return data[index];
    }

    public int getMin() {
        if (index < 0) {
            throw new RuntimeException("");
        }
        return min[index];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}