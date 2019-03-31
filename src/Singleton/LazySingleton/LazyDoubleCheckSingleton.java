package Singleton.LazySingleton;

/**
 * Created by oahnus on 2019/3/31
 * 11:34.
 */
public class LazyDoubleCheckSingleton {
    // 添加volatile 解決指令重排序的問題

    // CPU执行时会转换成JVM指令执行
    // 1. 为对象分配内存
    // 2. 初始化对象
    // 3. 关联对象与内存地址， 为对象赋值
    // 4. 用户初次访问
    // 指令执行时，顺序可能会颠倒 （指令重排序）

    private static volatile LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton() {}

    // Double Check
    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
