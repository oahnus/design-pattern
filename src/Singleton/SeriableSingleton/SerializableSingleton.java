package Singleton.SeriableSingleton;

import java.io.Serializable;

/**
 * Created by oahnus on 2019/3/31
 * 12:15.
 */
public class SerializableSingleton implements Serializable {
    private static final SerializableSingleton INSTANCE = new SerializableSingleton();
    private SerializableSingleton() {}

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    // ObjectOutputStream 在 反序列化对象时，在创建对象实例后，会检查是否有readResolve方法，
    // 如果有会运用反射调用 readResolve方法覆盖 对象实例
    private Object readResolve() {
        return INSTANCE;
    }
}
