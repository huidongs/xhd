package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author xhd
 * @Date 2021-05-12
 * @Des: 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 */
public class WaitNotifyPrintOddEvenSyn{
    private static Object lock = new Object();
    static int count;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100){
                    synchronized (lock){
                        if ((count&1)==0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"偶数").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100){
                    synchronized (lock){
                        if ((count&1)==1){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"奇数").start();
    }

}
