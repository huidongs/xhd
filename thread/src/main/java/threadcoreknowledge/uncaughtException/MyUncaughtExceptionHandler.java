package threadcoreknowledge.uncaughtException;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author xhd
 * @Date 2021-05-31
 * @Des:
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    private String name;
    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，终止了"+t.getName(),e);
        System.out.println(name+"捕获了异常"+t.getName());
    }
}
