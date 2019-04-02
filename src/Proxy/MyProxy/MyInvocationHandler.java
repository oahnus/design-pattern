package Proxy.MyProxy;

import java.lang.reflect.Method;

/**
 * Created by oahnus on 2019/4/2
 * 23:29.
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
