package test;

public class SynchronizedTest {
    private Object lock = new Object();

    public void test1(){
        synchronized (this){
            System.out.println("test1");
        }
    }

    public void test2(){
        synchronized (lock){
            System.out.println("test2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        SynchronizedTest test = new SynchronizedTest();
        new Thread(()->{
            test.test2();
        }).start();
        new Thread(()->{
            test.test1();
        }).start();
    }
}
