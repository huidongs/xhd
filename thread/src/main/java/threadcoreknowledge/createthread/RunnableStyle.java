package threadcoreknowledge.createthread;

/**
 * @Author: xhd
 * @Date: 2021-03-30
 * @Desc:
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程："+Thread.currentThread());
    }
}
        