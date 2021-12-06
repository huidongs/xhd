package jmm;

/**
 * @Author xhd
 * @Date 2021-06-03
 * @Des: 演示可见性带来的问题
 */
public class FieldVisibility {
    int a = 1;
    volatile int b = 2;

    private void print() {
        System.out.println("b = "+b+"; a= "+a);
    }

    private void change() {
        a = 3;
        b = a;
    }

    public static void main(String[] args) {
        FieldVisibility test = new FieldVisibility();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            }
        }).start();
    }


}
