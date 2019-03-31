package Singleton.RegisterSingleton;

/**
 * Created by oahnus on 2019/3/31
 * 饿汉式
 * 12:37.
 */
public enum  EnumSingleton {
    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }
}
