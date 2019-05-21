package Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by oahnus on 2019/4/1
 * 23:36.
 */
public class SubjectProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before");
        Object retVal = method.invoke(target, args);
        System.out.println("After");
        return retVal;
    }
}
