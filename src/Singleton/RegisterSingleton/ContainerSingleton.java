package Singleton.RegisterSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by oahnus on 2019/3/31
 * 12:53.
 *
 * 容器式单例
 */
public class ContainerSingleton {
    private static final ConcurrentHashMap<String, Object> container = new ConcurrentHashMap<>();

    private ContainerSingleton() {

    }

    public static Object getBean(String className) {
        synchronized (container) {
            if (!container.containsKey(className)) {
                Object object = null;
                try {
                    object = Class.forName(className);
                    container.put(className, object);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return container.get(className);
        }
    }
}
