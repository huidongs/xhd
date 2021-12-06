package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author xhd
 * @Date 2021-05-31
 * @Des:    演示join，主线程状态
 */
public class Join implements Runnable{
    Thread mainThread = Thread.currentThread();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(mainThread.getName()+"状态："+mainThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Join());
        thread.start();
        System.out.println("主线程开始等待子线程执行结束");
        //thread.join();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("主线程线程执行结束");

    }
}
