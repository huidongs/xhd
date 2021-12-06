package threadcoreknowledge.threadobjectclasscommonmethods;


/**
 * @Author xhd
 * @Date 2021-05-12
 * @Des: 两个线程交替打印0~100的奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEvenWait {
    private static final Object lock = new Object();
    static int count = 0;

    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    public static void main(String[] args) {
        new Thread(new turnRunning()).start();
        new Thread(new turnRunning()).start();
    }

    static class turnRunning implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

