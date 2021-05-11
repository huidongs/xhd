package threadcoreknowledge.stopthreads;

/**
 * @Author xhd
 * @Date 2021/5/10
 * @Des: 如果在执行的过程中每次都会调用sleep或wait等方法，那么不需要每次迭代都去判断是否已中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while (num <= 1000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是一百的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
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
