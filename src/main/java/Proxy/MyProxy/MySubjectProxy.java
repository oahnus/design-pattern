package Proxy.MyProxy;

import java.lang.reflect.Method;

/**
 * Created by oahnus on 2019/4/1
 * 23:36.
 */
public class MySubjectProxy implements MyInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return MyProxy.newProxyInstance(new MyProxyClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before My Request");
        Object retVal = method.invoke(target, args);
        System.out.println("After My Request");
        return retVal;
    }
}
