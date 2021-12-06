package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 饿汉式（静态代码块）
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE;
    static {
        INSTANCE = new Singleton2();
    }
    public Singleton2(){

    }
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
