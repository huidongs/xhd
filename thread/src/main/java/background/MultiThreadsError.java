package background;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xhd
 * @Date 2021-06-01
 * @Des:    第一种：运行结果出错，找出具体出错位置
 */
public class MultiThreadsError implements Runnable{
    static MultiThreadsError instance = new MultiThreadsError();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
    private final boolean[] marked = new boolean[100000];
    int index = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面的index值："+ instance.index);
        System.out.println("真实的index值："+ realIndex.get());
        System.out.println("错误次数："+ wrongCount.get());
    }
    @Override
    public void run() {
        marked[0]=true;
        for (int i = 0 ;i<50000;i++){
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index]&&marked[index-1]) {
                    System.out.println("出错位置：" + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
