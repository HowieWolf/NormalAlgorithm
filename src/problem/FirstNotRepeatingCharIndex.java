package problem;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @see FirstNotRepeatingChar
 */
public class FirstNotRepeatingCharIndex {

    class Node {
        int index;
        char val;
        Node next;
        boolean isFirst = true;
    }

    /**
     * 链表维护不重复的节点出现的顺序
     */
    private Node result;
    private Node tail;
    /**
     * 用空间换时间，时间复杂度 O(1)
     */
    private Node[] temp = new Node[128];

    private static final int FLAG_ERR = -1;

    public int find(String str) {
        if (str == null || str.length() == 0) {
            return FLAG_ERR;
        }
        for (int i = 0; i < str.length(); i++) {
            Node node = newNode(i, str.charAt(i));
            add(node);
            move();
        }
        return getResult();
    }

    private int getResult() {
        if (result == null) {
            return FLAG_ERR;
        } else {
            return result.index;
        }
    }

    private Node newNode(int index, char c) {
        Node node = new Node();
        node.val = c;
        node.index = index;
        return node;
    }

    private void move() {
        if (result == null || result.isFirst) {
            return;
        }
        do {
            result = result.next;
        } while (result != null && !result.isFirst);
    }

    private void add(Node node) {
        // 放到数组中
        Node current = temp[node.val];
        if (current == null) {
            // 只有没出现过的才可能是结果
            temp[node.val] = node;
            // 添加到链表中
            if (tail == null) {
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            // 初始化结果
            if (result == null) {
                result = node;
            }
        } else {
            current.isFirst = false;
        }
    }

    public static void main(String[] args) {
        FirstNotRepeatingCharIndex test = new FirstNotRepeatingCharIndex();
        int result = test.find("googgle");
        System.out.println(result);
    }
}
