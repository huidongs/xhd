package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 懒汉式（线程不安全）
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;

    public Singleton3(){}

    public static Singleton3 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
