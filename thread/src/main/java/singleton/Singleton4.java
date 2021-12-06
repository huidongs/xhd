package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 懒汉式（线程安全）
 */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    public Singleton4(){}

    public synchronized static Singleton4 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
