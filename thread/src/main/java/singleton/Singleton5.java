package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 懒汉式（线程不安全）（不推荐）
 */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    public Singleton5(){}

    public  static Singleton5 getInstance(){
        if (INSTANCE == null){
            synchronized(Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}
