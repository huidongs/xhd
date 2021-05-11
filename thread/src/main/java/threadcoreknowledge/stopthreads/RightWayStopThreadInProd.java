package threadcoreknowledge.stopthreads;

/**
 * @Author xhd
 * @Date 2021/5/10
 * @Des: 最佳实践：catch了InterruptedException之后的优先选择：在方法签名中抛出异常；那么在run中会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable{

    @Override
    public void run() {
        while (true&&!Thread.currentThread().isInterrupted()){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志，停止程序
                System.out.println("保存日志");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
