package Proxy.MyProxy;

import Proxy.Subject;

/**
 * Created by oahnus on 2019/4/2
 * 23:27.
 */
public class MyRealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Do My Request Method");
    }
}
