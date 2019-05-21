package Proxy.DynamicProxy;

import Proxy.Subject;

/**
 * Created by oahnus on 2019/4/2
 * 22:53.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("do real request");
    }
}
