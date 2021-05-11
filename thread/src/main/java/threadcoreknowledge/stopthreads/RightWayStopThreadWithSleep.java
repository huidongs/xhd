package threadcoreknowledge.stopthreads;

/**
 * @Author xhd
 * @Date 2021/5/10
 * @Des: 带有sleep的中断线程写法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while (num <= 300) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是一百的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
