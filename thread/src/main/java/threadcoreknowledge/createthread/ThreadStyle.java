package threadcoreknowledge.createthread;

/**
 * @Author: xhd
 * @Date: 2021-03-30
 * @Desc:
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("使用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
