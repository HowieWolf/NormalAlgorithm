package lock;

public class ProductCustomPattern {

    private final int size;
    private int count;

    public ProductCustomPattern(int size) {
        this.size = size;
    }

    void start() {
        new Thread(new Customer()).start();
        Thread factory = new Thread(new Factory());
        factory.start();
        new Thread(new Customer()).start();
        new Thread(new Factory()).start();
        new Thread(new Customer()).start();
        new Thread(new Factory()).start();
        new Thread(new Customer()).start();
        new Thread(new Factory()).start();
        new Thread(new Customer()).start();
        new Thread(new Factory()).start();
        new Thread(new Customer()).start();
        new Thread(new Factory()).start();
    }

    class Factory implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (ProductCustomPattern.this) {
                    while (count >= size) {
                        try {
                            System.out.println("生产休息");
                            ProductCustomPattern.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产-" + Thread.currentThread().getName() + "-" + count);
                    // 通知
                    /**
                     * 此处必须用 {@link Object#notifyAll()}
                     * 使用 {@link Object#notify()} 有可能造成死锁
                     * 假设此时 count = 0，且 notify 连续唤醒 Customer，那都会进入 wait
                     * 而后又连续唤醒 Factory，生产满后，会都进入 wait，则就出现了死锁
                     */
                    ProductCustomPattern.this.notifyAll();
                }
            }
        }
    }

    class Customer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (ProductCustomPattern.this) {
                    while (count <= 0) {
                        try {
                            System.out.println("消耗休息");
                            ProductCustomPattern.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消耗-" + Thread.currentThread().getName() + "-" + count);
                    // 通知
                    ProductCustomPattern.this.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductCustomPattern test = new ProductCustomPattern(15);
        test.start();
    }
}
