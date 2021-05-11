package threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author xhd
 * @Date 2021-05-11
 * @Des: 演示用volatile的局限：part2 陷入阻塞时，volatile是无法线程的，此例中，生产者生产速度很快，消费者消费速度慢，
 * 所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
            System.out.println("消费者不需要更多的数了");
        }
        //一旦不需要更多的数了，我们应该让生产者也停下来，但实际情况是并没有停止
        producer.canceled = true;
    }
}

class Producer implements Runnable {
    protected volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数,放入仓库");
                    storage.put(num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}

class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}
