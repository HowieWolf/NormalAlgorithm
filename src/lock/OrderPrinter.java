package lock;

public class OrderPrinter {
    private int i;
    private final int size;
    private final int max;

    OrderPrinter(int size, int max) {
        this.size = size;
        this.max = max;
    }

    void start() {
        for (int i = 0; i < size; i++) {
            Runnable r = new Printer(i);
            new Thread(r).start();
        }
    }

    class Printer implements Runnable {
        private int tag;

        Printer(int tag) {
            this.tag = tag;
        }

        @Override
        public void run() {
            synchronized (OrderPrinter.this) {
                while (i < max)
                    if (i % size == tag) {
                        System.out.println(Thread.currentThread().getName() + "==" + i++);
                        OrderPrinter.this.notifyAll();
                    } else {
                        try {
                            OrderPrinter.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }

    public static void main(String[] args) {
        OrderPrinter test = new OrderPrinter(4, 20);
        test.start();
    }
}
