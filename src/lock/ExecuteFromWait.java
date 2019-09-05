package lock;

/**
 * 测试 wait 后，是否是从 wait 处继续执行
 * 验证，获取锁后，从 wait 处继续执行
 */
public class ExecuteFromWait {


    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (ExecuteFromWait.this) {
                try {
                    System.out.println("wait");
                    ExecuteFromWait.this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after wait");
            }
        }
    }

    void start() {
        new MyThread().start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            notifyAll();
        }
    }

    public static void main(String[] args) {
        new ExecuteFromWait().start();
    }
}
