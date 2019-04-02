package Proxy.StaticProxy;

import Proxy.Subject;

/**
 * Created by oahnus on 2019/4/1
 * 22:52.
 */
public class SubjectProxy implements Subject {

    private RealSubject realSubject;

    public SubjectProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("Before Real Subject Handle Request");
        realSubject.request();
        System.out.println("After Real Subject Handle Request");
    }
}
