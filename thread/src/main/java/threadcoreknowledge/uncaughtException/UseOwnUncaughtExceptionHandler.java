package threadcoreknowledge.uncaughtException;


/**
 * @Author xhd
 * @Date 2021-05-31
 * @Des:
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-0").start();
        Thread.sleep(500);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(500);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(500);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }

}
