package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author xhd
 * @Date 2021-06-07
 * @Des: 必定发生死锁的情况
 */
public class ThreadMXBeanDetection implements Runnable {
    int flag = 0;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBeanDetection r1 = new ThreadMXBeanDetection();
        ThreadMXBeanDetection r2 = new ThreadMXBeanDetection();
        r1.flag = 0;
        r2.flag = 1;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads!=null&&deadlockedThreads.length>0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("发现死锁:"+threadInfo.getLockName());
            }
        }
    }
    @Override
    public void run() {
        System.out.println(flag);
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