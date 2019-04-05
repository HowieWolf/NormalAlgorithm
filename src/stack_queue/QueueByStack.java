package stack_queue;

import java.util.Stack;

public class QueueByStack<E> {

    private Stack<E> in = new Stack<>();
    private Stack<E> out = new Stack<>();

    public void offer(E o) {
        in.push(o);
    }

    public E poll() {
        if (out.size() == 0) {
            move();
        }
        return out.pop();
    }

    private void move() {
        for (E o : in) {
            out.push(o);
        }
    }
}
