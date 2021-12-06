package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @Author xhd
 * @Date 2021-06-02
 * @Des: 演示重排序现象，直到达到某个条件才停止，测试小概率事件(使用volatile解决重排序问题)
 */
public class OutOfOrderExecution {
    static volatile private int x = 0, y = 0;
    static volatile private int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            a = 0;b = 0;x = 0;y = 0;
            i++;
            CountDownLatch latch = new CountDownLatch(1);
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            one.start();two.start();latch.countDown();one.join();two.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次：" + " x = " + x + "," + "y = " + y);
                break;
            } else {
                System.out.println("第" + i + "次：" + " x = " + x + "," + "y = " + y);
            }
        }
    }
}
