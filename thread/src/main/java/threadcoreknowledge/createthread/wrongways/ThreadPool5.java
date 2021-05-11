package threadcoreknowledge.createthread.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author xhd
 * @Date 2021/5/8
 * @Des: 线程池创建线程的方法
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new TaskTest() {
            });
        }
    }
}

class TaskTest implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
