package Singleton.LazySingleton;

/**
 * Created by oahnus on 2019/3/31
 * 11:47.
 *
 * 性能最优
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
    private static class LazyHolder {
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }
}
