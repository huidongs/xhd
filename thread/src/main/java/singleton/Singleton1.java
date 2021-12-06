package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 饿汉式（静态常量，可用）
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    public Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
