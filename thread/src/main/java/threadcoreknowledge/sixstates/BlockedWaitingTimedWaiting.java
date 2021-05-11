package threadcoreknowledge.sixstates;

/**
 * @Author xhd
 * @Date 2021-05-11
 * @Des: 展示blocked，waiting，timedwaiting
 */
public class BlockedWaitingTimedWaiting implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(1);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        Thread.sleep(1200);
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
