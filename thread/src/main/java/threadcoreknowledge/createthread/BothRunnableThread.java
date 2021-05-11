package threadcoreknowledge.createthread;
/**
* @Description: 同时使用runnable和thread
* @Author: xhd
* @Date: 2021/5/8
*/
public class BothRunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("zzz");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle(){
            @Override
            public void run() {
                System.out.println("我来自runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
