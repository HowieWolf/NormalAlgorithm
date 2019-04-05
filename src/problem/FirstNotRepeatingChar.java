package problem;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @see FirstNotRepeatingCharIndex
 */
public class FirstNotRepeatingChar {

    class Node {
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

    private static final char FLAG_ERR = '#';

    private char currentChar;

    public void insertChar(char ch) {
        this.currentChar = ch;
    }

    public char find() {
        Node node = newNode(currentChar);
        add(node);
        move();
        return getResult();
    }

    private char getResult() {
        if (result == null) {
            return FLAG_ERR;
        } else {
            return result.val;
        }
    }

    private Node newNode(char c) {
        Node node = new Node();
        node.val = c;
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
}
