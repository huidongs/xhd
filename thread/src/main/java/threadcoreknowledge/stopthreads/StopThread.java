package threadcoreknowledge.stopthreads;

/**
 * @Author xhd
 * @Date 2021-05-11
 * @Des: 错误的停止方式：用stop()来停止线程，会导致线程运行一般突然停止，没办法完成一个基本单位的操作（一个连队），
 *                    会造成脏数据（有的连队多领，有的少领）。
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        //模拟指挥军队：一共5个连队，每个连队10人，以连队为单位，方法武器弹药，叫到号的士兵前去领取
        for (int i =0;i<5;i++) {
            System.out.println("连队" + i + "开始领取");
            for (int j = 0; j<10;j++){
                System.out.println(j);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "已经领取完毕");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(1000);
        thread.stop();
    }
}
