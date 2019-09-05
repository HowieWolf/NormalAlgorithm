package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式
 * 使用 {@link java.util.concurrent.locks.Lock} 实现
 */
public class ProductCustomPatternByLock {

    private Lock lock = new ReentrantLock(true);
    // 使用不同的 condition 能够实现通知不同类型的等待者
    private Condition customCondition = lock.newCondition();
    private Condition productCondition = lock.newCondition();

    private final int size;
    private int count;

    public ProductCustomPatternByLock(int size) {
        this.size = size;
    }

    private class Product extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count >= size) {
                        System.out.println("生产者-" + Thread.currentThread().getName() + "休息");
                        productCondition.await();
                    }
                    count++;
                    System.out.println("生产者-" + Thread.currentThread().getName() + "生产-" + count);
                    customCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class Custom extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count <= 0) {
                        System.out.println("消费者-" + Thread.currentThread().getName() + "休息");
                        customCondition.await();
                    }
                    count--;
                    System.out.println("消费者-" + Thread.currentThread().getName() + "消费-" + count);
                    productCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    void start() {
        new Product().start();
        new Custom().start();
        new Product().start();
        new Custom().start();
        new Product().start();
        new Custom().start();
        new Product().start();
        new Custom().start();
    }

    public static void main(String[] args){
        new ProductCustomPatternByLock(15).start();
    }
}
