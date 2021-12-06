package deadlock;

/**
 * @Author xhd
 * @Date 2021-06-07
 * @Des: 必定发生死锁的情况
 */
public class MustDeadLock implements Runnable {
    int flag = 0;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 0;
        r2.flag = 1;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        if (flag == 0) {
            synchronized (object1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("线程1拿到两把锁");
                }
            }
        }
        if (flag == 1) {
            synchronized (object2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("线程2拿到两把锁");
                }
            }

        }

    }
}