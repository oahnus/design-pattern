package Proxy.StaticProxy;

import Proxy.Subject;

/**
 * Created by oahnus on 2019/4/1
 * 22:51.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Real Subject Handle Request");
    }
}
