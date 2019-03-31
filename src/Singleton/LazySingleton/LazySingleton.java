package Singleton.LazySingleton;

/**
 * Created by oahnus on 2019/3/31
 * 11:20.
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}

    // 保证线程安全
    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
