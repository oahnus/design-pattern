package Singleton.HungrySingleton;

/**
 * Created by oahnus on 2019/3/31
 * 11:16.
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
