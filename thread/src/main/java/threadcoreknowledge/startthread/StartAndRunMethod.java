package threadcoreknowledge.startthread;

/**
 * @Author xhd
 * @Date 2021/5/10
 * @Des: 对比start和run两种启动线程方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        new Thread(runnable).start();
    }
}