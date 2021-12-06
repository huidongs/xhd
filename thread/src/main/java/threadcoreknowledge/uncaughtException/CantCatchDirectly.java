package threadcoreknowledge.uncaughtException;

/**
 * @Author xhd
 * @Date 2021-06-01
 * @Des: 1.不加Try catch 抛出4个异常，都带异常名字
 *       2.加了try catch 期望捕获到第一个线程的异常,就能打印出catch exception；
 *         说明线程的异常不能用传统的方式捕获
 */
public class CantCatchDirectly implements Runnable {
    public static void main(String[] args) {
        try {
            new Thread(new CantCatchDirectly(), "MyThread-0").start();
            Thread.sleep(500);
            new Thread(new CantCatchDirectly(), "MyThread-1").start();
            Thread.sleep(500);
            new Thread(new CantCatchDirectly(), "MyThread-2").start();
            Thread.sleep(500);
            new Thread(new CantCatchDirectly(), "MyThread-3").start();
        } catch (InterruptedException e) {
            System.out.println("catch exception");
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
