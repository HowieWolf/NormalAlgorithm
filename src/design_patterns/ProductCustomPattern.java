package design_patterns;

/**
 * 生产者-消费者模式
 * 公用一个篮子，生产者向篮子里丢产品，消费者从篮子中取产品
 * 如果篮子中已经满了，生产者要休息一下，同时提醒消费者消费
 * 如果篮子中已经空了，消费者要休息一下，同时提醒生产者生产
 *
 * 由于 wait/notify 方法必须在 synchronized 代码块中执行，
 * 所以如果将同步操作封装在篮子中，外部就不要调用 wait/notify，而要使用 sleep/interrupt
 *
 */
public class ProductCustomPattern {

    public static void main(String[] args) throws InterruptedException {
        MyQueue<Integer> queue = new MyQueue<>();
        Producer<Integer> producer = new Producer<>(queue);
        Customer<Integer> customer = new Customer<>(queue);
        producer.push = () -> {
            customer.interrupt();
        };
        customer.push = () -> {
            producer.interrupt();
        };
        producer.produce();
        customer.custom();
        Thread.sleep(50000);
        queue.isStoped = true;
        producer.join();
        customer.join();
        System.out.println("finish");
    }
}

class Producer<E> extends Thread {
    MyQueue<E> queue;
    PushOther push;

    public Producer(MyQueue<E> q) {
        queue = q;
    }

    public void produce() {
        start();
    }

    @Override
    public void run() {
        while (!queue.isStoped) {
            if (queue.offer(doProduce())) {
                System.out.println("produce");
            } else {
                if (push != null) {
                    push.push();
                }
                doRest();
            }
        }
    }

    private E doProduce() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("please produce faster");
        }
        return (E) new Object();
    }

    private void doRest() {
        System.out.println("producer rest");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("please produce faster");
        }
    }
}

class Customer<E> extends Thread {

    private MyQueue<E> queue;
    PushOther push;


    public Customer(MyQueue<E> q) {
        queue = q;
    }

    public void custom() {
        start();
    }

    @Override
    public void run() {
        while (!queue.isStoped) {
            if (queue.poll()) {
                doEat();
            } else {
                if (push != null) {
                    push.push();
                }
                doRest();
            }
        }
    }

    private void doEat() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("please eat faster");
        }
        System.out.println("eat");
    }

    private void doRest() {
        System.out.println("customer rest");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("please eat faster");
        }
    }
}

class MyQueue<E> {

    boolean isStoped = false;
    private int size;
    private int hold = 5;

    public boolean offer(E e) {
        synchronized (this) {
            if (size < hold) {
                size++;
                System.out.println("offer-size=" + size);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean poll() {
        synchronized (this) {
            if (size > 0) {
                size--;
                System.out.println("poll-size=" + size);
                return true;
            } else {
                return false;
            }
        }
    }

    public int size() {
        return size;
    }
}

interface PushOther {
    void push();
}
