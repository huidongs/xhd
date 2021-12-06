package singleton;

/**
 * @Author xhd
 * @Date 2021-06-04
 * @Des: 懒汉式（线程不安全）（不推荐）
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    public Singleton6(){}

    public  static Singleton6 getInstance(){
        if (instance == null){
            synchronized(Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
