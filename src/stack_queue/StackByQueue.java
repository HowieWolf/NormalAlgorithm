package stack_queue;

import java.util.LinkedList;

public class StackByQueue<E> {

    private LinkedList<E> in = new LinkedList<>();
    private LinkedList<E> out = new LinkedList<>();

    public void push(E o) {
        in.push(o);
    }

    public E pop() {
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
