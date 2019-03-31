package Singleton.LazySingleton;

/**
 * Created by oahnus on 2019/3/31
 * 11:47.
 *
 * 不占用空间，性能好
 */
public class LazyInnerClassSingleton {
    // 私有构造方法中添加判断 避免反射破坏单例的创建
    private LazyInnerClassSingleton() {
        if (LazyHolder.instance != null) {
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    public synchronized static LazyInnerClassSingleton getInstance() {
        return LazyHolder.instance;
    }

    // instance 的实例化逻辑要等到 getInstance方法调用时才会执行
    // 静态内部类在外部类加载时， 不会同时加载，只有当内部类的某个成员变量，方法，或构造函数被调用时，才会加载内部类
    private static class LazyHolder {
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }
}
